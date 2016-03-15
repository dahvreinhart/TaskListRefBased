public class TaskListRefBased implements TaskList {
    public TaskListNode head;
    public TaskListNode curr;
    public TaskListNode prev;
    
    public TaskListRefBased() {
        head = null;
        curr = null;
        prev = null;
    }


    public int getLength() {
        return length(head);
    }
    private int length(TaskListNode n) {
        if (n== null) {
            return 0;
        }
        else {
            return length(n.next) + 1;
        }
    }


    public boolean isEmpty() {
        if (head == null) 
            return true;
        else
            return false;
    }



    public Task removeHead() {
        TaskListNode temp = head;
        Task remHead = new Task(temp.priority , temp.number);
        head = head.next;
        return remHead;
    }
    

    
    public Task remove(Task t) {
        prev = null;
        curr = head;
        while (curr != null) {
            if (t.priority == curr.priority && t.number == curr.number) {
                break;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        if (curr == null)
            return null;
        if (prev == null)
            head = curr.next;
        else
            prev.next = curr.next;
        return t;
    }


    public void insert(Task t) {
        TaskListNode newNode = new TaskListNode(t.priority , t.number);
        prev = null;
        curr = head;
        while(curr != null) {
            if (curr.priority > t.priority) {
                prev = curr;
                curr = curr.next;
            }
            else if (t.priority == curr.priority) {
                if (t.number > curr.number) {
                    prev = curr;
                    curr = curr.next;
                }
                else 
                    break;
            }
            else
                break;
        }
        newNode.next = curr;
        if (prev == null) 
            head = newNode;
        else
            prev.next = newNode;
    }


    public Task retrieve(int i) {
        prev = null;
        curr = head;
        Task retrieval = null;
        int listPosition = 0;
        while (curr != null) {
            if (listPosition == i) {
                retrieval = new Task(curr.priority , curr.number);
                return retrieval;
            }
            else {
                prev = curr;
                curr = curr.next;
                listPosition++;
            }
        }
        return null;
    }
}

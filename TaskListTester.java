public class TaskListTester {
    public static void main(String[] args) {
        TaskList test1 = new TaskListRefBased();
        
        //Test 1: isEmpty
        //Expected that the list at this point is empty...
        boolean emptyTest = test1.isEmpty();
        if (emptyTest == true) 
            System.out.println("Test 1: Passed!");
        else
            System.out.println("Test 1: FAILED");
            
        //Test 2: getLength
        //Expected that the length of the list at this point is 0...
        int lengthTest = test1.getLength();
        if (lengthTest == 0)
            System.out.println("Test 2: Passed!");
        else
            System.out.println("Test 2: FAILED");
            
        //Test 3: Insertion
        //Expected length after this test is 3...
        Task ins1 = new Task(5 , 1);
        Task ins2 = new Task(10 , 2);
        Task ins3 = new Task(5 , 3);
        Task ins4 = new Task(8 , 4);
        test1.insert(ins1);
        test1.insert(ins2);
        test1.insert(ins3);
        test1.insert(ins4);
        int insTest = test1.getLength();
        if (insTest == 4)
            System.out.println("Test 3: Passed!");
        else
            System.out.println("Test 3: FAILED");
            
        //Test 4: Deletion
        //Expected length after this test is 2..
        test1.remove(ins1);
        int delTest = test1.getLength();
        if (delTest == 3)
            System.out.println("Test 4: Passed!");
        else
            System.out.println("Test 4: FAILED");
            
        //Test 5: Remove Head
        //Expected that after this test, the removed object is ins2 from Test 3...
        Task remHeadTest = test1.removeHead();
        if (remHeadTest.priority == 10 && remHeadTest.number == 2)
            System.out.println("Test 5: Passed!");
        else
            System.out.println("Test 5: FAILED");
                
        //Test 6: Retrieval
        //Expected item to be retrieved at position 2 has priority 7...
        Task ins5 = new Task(14 , 3);
        Task ins6 = new Task(4 , 4);
        Task ins7 = new Task(7 , 5);
        Task ins8 = new Task(9 , 6);
        test1.insert(ins5);
        test1.insert(ins6);
        test1.insert(ins7);
        test1.insert(ins8);
        Task retTest = test1.retrieve(3);
        if (retTest.priority == 7)
            System.out.println("Test 6: Passed!");
        else
            System.out.println("Test 6: FAILED");
            
        //Test 7: Complex Test (A)
        //Is the order of the resulting TaskList really sorted by priority and number?
        int[] expectedOrder = {93 , 97 , 107 , 1 , 2}; //the expected order of the objects in the list according to number
        TaskList test2 = new TaskListRefBased();
        boolean t7 = true;
        test2.insert(new Task(12 , 1));
        test2.insert(new Task(5 , 2));
        test2.insert(new Task(27 , 93));
        test2.insert(new Task(14 , 107));
        test2.insert(new Task(14 , 97));
        for (int i = 0; i < expectedOrder.length; i++) {
            Task a = test2.retrieve(i);
            if (a != null && a.number != expectedOrder[i]){
                t7 = false;
                break;
            }
            else if (a == null) {
                t7 = false;
                break;
            }
        }
        if (t7)
            System.out.println("Test 7: Passed!");
        else
            System.out.println("Test 7: FAILED");
            
        //Test 8: Complex Test (B)
        //After the deletion of a node, is the new list order still correct?
        TaskList test3 = new TaskListRefBased();
        boolean t8 = true;
        int[] newExpected = {102 , 14 , 7 , 67 , 98};
        test3.insert(new Task(43 , 7));
        test3.insert(new Task(60 , 102));
        test3.insert(new Task(5 , 98));
        test3.insert(new Task(59 , 14));
        test3.insert(new Task(17 , 67));
        test3.insert(new Task(31 , 4));
        Task toBeRemoved = new Task(31 , 4);
        test3.remove(toBeRemoved);
        for (int j = 0; j < newExpected.length; j++) {
            Task b = test3.retrieve(j);
            if (b != null && b.number != newExpected[j]){
                t8 = false;
                break;
            }
            else if (b == null) {
                t8 = false;
                break;
            }
        }
        if (t8)
            System.out.println("Test 8: Passed!");
        else
            System.out.println("Test 8: FAILED");
        
        //Test 9: Complex Test (C)
        //Once you remove all the tasks from a populated list, is it correctly empty?
        //Also, is the length of the array correctly 0?
        TaskList test4 = new TaskListRefBased();
        Task eg1 = new Task(21 , 4);
        Task eg2 = new Task(43 , 88);
        Task eg3 = new Task(78 , 73);
        Task eg4 = new Task(38 , 3);
        test4.insert(eg1);
        test4.insert(eg2);
        test4.insert(eg3);
        test4.insert(eg4);
        int t9a = test4.getLength();
        test4.remove(eg1);
        test4.remove(eg2);
        test4.remove(eg3);
        test4.remove(eg4);
        int t9b = test4.getLength();
        boolean t9c = test4.isEmpty();
        if (t9a == 4 && t9b == 0 && t9c)
            System.out.println("Test 9: Passed!");
        else
            System.out.println("Test 9: FAILED");
        
        //Test 10: Complex Test (D)
        //A simulation of the task list in operation with random length checks, empty checks and position checks
        TaskList test5 = new TaskListRefBased();
        Task ex1 = new Task(32 , 7);
        Task ex2 = new Task(54 , 90);
        Task ex3 = new Task(98 , 91);
        boolean aa = test5.isEmpty(); //true?
        test5.insert(ex1);
        test5.insert(ex2);
        test5.insert(ex3);
        boolean ab = test5.isEmpty(); //false?
        int ac = test5.getLength(); //3?
        Task ad = test5.retrieve(1); //Task ex2?
        test5.remove(ex2);
        int ae = test5.getLength(); //2?
        Task ex4 = new Task(58 , 102);
        Task ex5 = new Task(58 , 101);
        Task ex6 = new Task(58 , 201);
        test5.insert(ex4);
        test5.insert(ex5);
        test5.insert(ex6);
        int af = test5.getLength(); //5?
        for (int k = 0; k < af; k++) {
            test5.removeHead();
        }
        boolean ag = test5.isEmpty(); //true?
        int ah = test5.getLength(); //0?
        if (aa && !ab && ac == 3 && ad.priority == ex2.priority && ad.number == ex2.number && ae == 2 && af == 5 && ag && ah == 0)
            System.out.println("Test 10: Passed!");
        else
            System.out.println("Test 10: FAILED");
    }
} //end of tester class
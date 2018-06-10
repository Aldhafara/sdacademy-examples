package sdacademy.Swing;

 class Person {


    public static final int ADULT_AGE = 18;
            private String name;
            private String lastName;
            private int age;



            public Person(String name, String lastName, int age){
                this.name = name;
                this.lastName = lastName;
                this.age = age;
            }

         @Override
         public String toString() {
                 return "Person{ name= " + name + ", lastName= " + lastName + ",age: " + age + "}";
         }

         public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

         public void printPerson(String name) {
                 System.out.println("Firstname: " + name + ", Lastname: " + lastName + ", age: " + age);
         }


    public boolean isAdult() {
        return getAge()>ADULT_AGE;
    }




}

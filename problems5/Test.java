class ThrowsExecp {

    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[])
    {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль недопустимо!");
            
        } finally {
            System.out.println("IMGAY");
        }
    }
}
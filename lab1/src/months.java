public class months {
    public static void main(String[] args) {

        int suma_luni = 0;

        int[] month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November",
                "December" };

        System.out.println("Lunile anului:");
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i] + " : " + month_days[i]);
        }

        System.out.println("Luni cu 31 zile:");
        for (int i = 0; i < month_days.length; i++) {
            if (month_days[i] == 31) {
                System.out.println(months[i] + " : " + month_days[i]);
            }
        }
        System.out.println("Luni cu mai putin de 31 zile:");
        for (int i = 0; i < month_days.length; i++) {
            if (month_days[i] < 31) {
                suma_luni += month_days[i];
                System.out.println(months[i] + " : " + month_days[i]);
            }
        }
        System.out.println("Suma luni cu mai putin de 31 zile: " + suma_luni);

        System.out.println("Lunile anului prescurtate:");
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i].substring(0, 3) + " : " + month_days[i]);
        }
    }
}

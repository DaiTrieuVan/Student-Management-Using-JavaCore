package utils;

public class Validator {
    final static String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    final static String phoneRegex = "^0[0-9]{9}$";
    final static String nameRegex = "^[\\p{Lu}][\\p{Ll}]*(\\s[\\p{Lu}][\\p{Ll}]*)*$";


    public boolean checkMSV(String msv) {
        return ((msv.matches("^SV\\d+$")));
    }

    public boolean checkEmail(String email) {
        return email.matches(emailRegex);
    }

    public boolean checkPhone(String sdt) {
        return sdt.matches(phoneRegex);
    }

    public boolean checkName(String name) {
        return name.matches(nameRegex);
    }
}

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;

        // Regex untuk validasi email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}

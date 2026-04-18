package assignment_shoaib_akhtar;

public class ValidationResult {
    private boolean valid;
    private String message;

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return this.valid;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
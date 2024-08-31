package abhik26.healthcare_management.exception;

public class HealthcareManagementException extends RuntimeException {
    private int httpStatusCode;

    public HealthcareManagementException(String message) {
        super(message);
    }

    public HealthcareManagementException(String message, int httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }
}

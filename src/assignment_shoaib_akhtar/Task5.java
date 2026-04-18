package assignment_shoaib_akhtar;

import java.util.List;

public class Task5 {

    public ValidationResult validate(Document doc) {
        try {
            // FIX: use specific exception for validation instead of generic RuntimeException
            if (doc == null) {
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            // FIX: handle null and empty content safely
            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {
            // FIX: Expected validation failure — avoid full stack trace to prevent log flooding
            // NOTE: SLF4J logger removed to keep project dependency-free for evaluation/compilation
            System.out.println("WARN: Validation failed: " + e.getMessage());

            // FIX: Do not return null — return meaningful validation result
            return new ValidationResult(false, e.getMessage());

        } catch (Exception e) {
            // FIX: Unexpected errors should still be visible for debugging
            // NOTE: Using printStackTrace instead of logger to avoid external dependencies
            System.out.println("ERROR: Unexpected error during validation");
            e.printStackTrace();

            // FIX: Do not swallow exception — rethrow
            throw e;
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX: Previously swallowed exception — now logging for visibility
                // NOTE: Logger removed to keep solution dependency-free
                System.out.println("ERROR: Failed processing document in batch");
                e.printStackTrace();
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return new ValidationResult(true, "OK");
    }

    private void saveResult(ValidationResult r) {
        // existing logic
    }
}
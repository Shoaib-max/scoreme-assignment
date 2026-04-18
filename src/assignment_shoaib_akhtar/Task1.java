package assignment_shoaib_akhtar;

import java.util.*;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null input 
        if (accounts == null) {
            return result;
        }

        Date now = new Date();

        for (LoanAccount account : accounts) {
            // FIX: skip null account objects
            if (account == null) {
                continue;
            }

            // FIX: Handle null dueDate to avoid NullPointerException
            if (account.getDueDate() != null && account.getDueDate().before(now)) {

                // FIX: only accounts with positive outstanding balance are added
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }
        return result;
    }
}

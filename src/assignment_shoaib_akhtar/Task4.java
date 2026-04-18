package assignment_shoaib_akhtar;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

public class Task4 {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                int month, int year)
            throws SQLException {

        List<ReportEntry> entries = new ArrayList<>();

        // FIX: use try-with-resources to close resources automatically
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM report_entries " +
                             "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                             "AND YEAR(entry_date) = ?"
             )) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            // FIX: include ResultSet in try-with-resources
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }

        return entries;
    }

    private ReportEntry mapRow(ResultSet rs) {
        return new ReportEntry();
    }
}

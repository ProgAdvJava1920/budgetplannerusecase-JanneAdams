package be.pxl.student.dao;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.*;
import java.time.LocalDateTime;

public class PaymentDAO {

    private static final String SELECT_BY_ID = "SELECT * FROM payment WHERE id = ?";
    private static final String UPDATE = "UPDATE payment SET date=? amount=? currency=? detail=?, accountId=? counterAccountId=? labelId=? WHERE id = ?";
    private static final String INSERT = "INSERT INTO payment (date, amount, currency, detail, accountId, counterAccountId, labelId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM payment WHERE id = ?";
    private String url;
    private String user;
    private String password;

    public PaymentDAO(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Payment createPayment(Payment payment){
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, Date.valueOf(payment.getDate().toLocalDate()));
            stmt.setFloat(2, payment.getAmount());
            stmt.setString(3, payment.getCurrency());
            stmt.setString(4, payment.getDetail());
            stmt.setInt(5, payment.getAccountId());
            stmt.setInt(6, payment.getCounterAccountId());
            stmt.setInt( 7, payment.getLabelId());
            if (stmt.executeUpdate() == 1) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        payment.setId(rs.getInt(1));
                        return payment;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean updatePayment(Payment payment){
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
            stmt.setDate(1, Date.valueOf(payment.getDate().toLocalDate()));
            stmt.setFloat(2, payment.getAmount());
            stmt.setString(3, payment.getCurrency());
            stmt.setString(4, payment.getDetail());
            stmt.setInt(5, payment.getAccountId());
            stmt.setInt(6, payment.getCounterAccountId());
            stmt.setInt( 7, payment.getLabelId());
            return stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean deletePayment(int id){
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(DELETE)) {
            stmt.setLong(1, id);
            return stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Payment readPayment(int id){
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapPayment(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Payment mapPayment(ResultSet rs) throws SQLException {
        Payment payment = new Payment(rs.getTimestamp("date").toLocalDateTime(),rs.getFloat("amount"), rs.getString("currency"), rs.getString("detail"), rs.getInt("accountId"), rs.getInt("counterAccountId"), rs.getInt("labelId"));
        payment.setId(rs.getInt("id"));
        return payment;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

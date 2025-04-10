package test;


import dao.DAO;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {

    private static Connection connection;

    @BeforeAll
    static void setUp() throws ClassNotFoundException {
        connection = DAO.getInstance();
    }

    @Test
    void testGetInstanceNotNull() {
        assertNotNull(connection, "La connexion  null");
    }

    @Test
    void testConnectionIsValid() throws SQLException {
        assertTrue(connection.isValid(2), "La connexion à la base de données n'est pas valide");
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Connexion fermée après les tests.");
        }
    }
}
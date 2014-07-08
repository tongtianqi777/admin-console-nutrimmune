package model.daos;

import model.beans.Protocol;
import model.beans.ProtocolStatus;

import java.sql.SQLException;

/**
 * Author: shim.
 * Creation date: 4/18/14.
 */
public class TestDAO {
    public static void main(String args[]) {
        try {
            ProtocolDAO protocolDAO = new ProtocolDAO();
//            UserDAO userDAO = new UserDAO();
//            UserCollabServer usr = userDAO.getUser("sankhasp@cmu.edu");
//
//
//
           // Class.forName("org.postgresql.Driver");
            Protocol prot = protocolDAO.getProtocolById(1);
            protocolDAO.uploadProtocol(prot);
            protocolDAO.updateProtocolStatus(prot.getId(), ProtocolStatus.DENIED);
            protocolDAO.updateProtocolTimePlayed(prot.getId(), 200);
            protocolDAO.searchProtocolByText("Fat lose");
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }
    }

}

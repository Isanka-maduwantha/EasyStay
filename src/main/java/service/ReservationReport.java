

import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import util.DBConnection;


public class ReservationReport {


    public static void main(String[] args) {


        try {


            // Connect database
            Connection con = DBConnection.getConnection();


            // Location of Jasper file
            String reportPath =
            "src/reports/reservation_report.jrxml";


            // Compile jrxml file
            JasperReport jasperReport =
            JasperCompileManager.compileReport(reportPath);



            // Parameters (optional)
            HashMap<String,Object> parameters =
            new HashMap<>();

            parameters.put(
                    "title",
                    "EasyStay Reservation Report"
            );



            // Fill report using database
            JasperPrint jasperPrint =
            JasperFillManager.fillReport(
                    jasperReport,
                    parameters,
                    con
            );



            // Display report
            JasperViewer.viewReport(
                    jasperPrint,
                    false
            );


            System.out.println(
            "Report Generated Successfully"
            );


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }
}
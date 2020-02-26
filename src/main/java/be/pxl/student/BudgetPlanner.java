package be.pxl.student;

import be.pxl.student.entity.Account;
import be.pxl.student.util.BudgetPlannerImporter;
import be.pxl.student.entity.Account;
import be.pxl.student.util.BudgetPlannerImporter;

import java.util.logging.Logger;

public class BudgetPlanner {
    public static void main(String[] args) {
        //todo localdatetime
        BudgetPlannerImporter importer=new BudgetPlannerImporter("src\\main\\resources\\account_payments.csv");
        Account account= importer.readFile();
        System.out.println(account);
    }

}

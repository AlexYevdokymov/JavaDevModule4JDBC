package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Database db = Database.getInstance();
    private final Statement st;

    {
        try {
            st = db.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> res = new ArrayList<>();
        String script = db.getSqlFromFile("./sql/find_max_projects_client.sql");
        try {
            ResultSet rs = st.executeQuery(script);
            while (rs.next()) {
                String str = rs.getString("name");
                int i = rs.getInt("project_count");
                MaxProjectCountClient mpcc = new MaxProjectCountClient(str, i);
                res.add(mpcc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static class MaxProjectCountClient {
        private final String name;
        private final int projectCount;

        public MaxProjectCountClient(String name, int projectCount) {
            this.name = name;
            this.projectCount = projectCount;
        }

        @Override
        public String toString() {
            return "MaxProjectCountClient{" +
                    "name='" + name + '\'' +
                    ", projectCount=" + projectCount +
                    '}';
        }
    }
    public List<LongestProject> findLongestProject(){
        List<LongestProject> res = new ArrayList<>();
        String script = db.getSqlFromFile("./sql/find_longest_project.sql");
        try {
            ResultSet rs = st.executeQuery(script);
            while (rs.next()) {
                String str = rs.getString("name");
                int i = rs.getInt("month_count");
                LongestProject lp = new LongestProject(str, i);
                res.add(lp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static class LongestProject {
        private final String name;
        private final int monthCount;

        public LongestProject(String name, int projectCount) {
            this.name = name;
            this.monthCount = projectCount;
        }

        @Override
        public String toString() {
            return "LongestProject{" +
                    "name='" + name + '\'' +
                    ", monthCount=" + monthCount +
                    '}';
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> res = new ArrayList<>();
        String script = db.getSqlFromFile("./sql/find_max_salary_worker.sql");
        try {
            ResultSet rs = st.executeQuery(script);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String bthd = rs.getString("birthday");
                String lvl = rs.getString("level");
                int slr = rs.getInt("salary");
                MaxSalaryWorker msw = new MaxSalaryWorker(id,name,bthd,lvl,slr);
                res.add(msw);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static class MaxSalaryWorker {
        private final int id;
        private final String name;
        private final String birthday;
        private final String level;
        private final int salary;

        public MaxSalaryWorker(int id, String name, String birthday, String level, int salary) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.level = level;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "MaxSalaryWorker{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", level='" + level + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> res = new ArrayList<>();
        String script = db.getSqlFromFile("./sql/find_youngest_eldest_workers.sql");
        try {
            ResultSet rs = st.executeQuery(script);
            while (rs.next()) {
                String tp = rs.getString("type");
                String name = rs.getString("name");
                String bthd = rs.getString("birthday");
                YoungestEldestWorkers yew = new YoungestEldestWorkers(tp,name,bthd);
                res.add(yew);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static class YoungestEldestWorkers {
        private final String type;
        private final String name;
        private final String birthday;

        public YoungestEldestWorkers(String type, String name, String birthday) {
            this.type = type;
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String
        toString() {
            return "YoungestEldestWorkers{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", birthday='" + birthday + '\'' +
                    '}';
        }
    }

    public List<ProjectPrices> printProjectPrices(){
        List<ProjectPrices> res = new ArrayList<>();
        String script = db.getSqlFromFile("./sql/print_project_prices.sql");
        try {
            ResultSet rs = st.executeQuery(script);
            while (rs.next()) {
                String name = rs.getString("name");
                long price = rs.getLong("price");
                ProjectPrices ppp = new ProjectPrices(name,price);
                res.add(ppp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static class ProjectPrices {
        private final String name;
        private final long price;

        public ProjectPrices(String name, long price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProjectPrices{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}

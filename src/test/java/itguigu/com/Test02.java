package itguigu.com;

import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author darren
 * @create 2020-11-21 22:10
 */
public class Test02 {
    private SqlSession sqlSession;
    private EmployeeMapper mapper;

    @Before
    public void getSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(EmployeeMapper.class);

    }

    @Test
    public void addEmployee(){

        Employee emp = new Employee();
        emp.setLastName("darren");
        emp.setGender("男");
        emp.setEmail("darren@qq.com");
        try{
            mapper.addEmployee(emp);
            sqlSession.commit();

        }catch (Exception e){
                sqlSession.rollback();
        }
        sqlSession.close();
    }
    @Test
    public void deleteEmployee(){
        try {
            mapper.deleteEmployee(1);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
    }
    @Test
    public void updateEmployee(){
        Employee emp = new Employee();
        emp.setId(2);
        emp.setLastName("jack2");
        emp.setGender("男");
        emp.setEmail("jack@qq.com");
        try{
            mapper.updateEmployee(emp);
            sqlSession.commit();

        }catch (Exception e){
            sqlSession.rollback();
        }
        sqlSession.close();
    }
    @Test
    public void selectEmployee(){
        List<Employee> employees = mapper.selectEmployee();
        System.out.println(employees);
    }


}

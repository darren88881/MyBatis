package itguigu.com;

import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class Test01 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void getSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

    }

    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee emp = sqlSession.selectOne("myEmployee.selectEmp", 1);
        System.out.println(emp);
    }
}

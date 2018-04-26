package insert;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam01 {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(
                "select/mybatis-config.xml");
        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        
        Board board = new Board();
        board.setTitle("제목");
        board.setContent("내용");
        
        int count = sqlSession.insert("BoardMapper.insertBoard", board);
        System.out.println(count);
        // mybatis에서는 autocommit이 기본으로 false이기 때문에
        // 다음 메서드를 호출하여 DBMS에게 작업 결과를 진짜 테이블에 반영하라고 명령을 내린다.
        sqlSession.commit();
        sqlSession.close();
        
                
    }

}

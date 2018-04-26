package select;

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
        
        HashMap<String,Object> paramMap = new HashMap<>();
        paramMap.put("startIndex", 9);
        paramMap.put("pageSize", 3);
        
        List<Board> list =
                sqlSession.selectList("BoardMapper.selectBoard", paramMap);
        
        for(Board board : list) {
            System.out.printf("%d, %s, %s, %s\n", 
                    board.getNo(), 
                    board.getTitle(), 
                    board.getContent(),
                    board.getRegisteredDate());
        }
        
        sqlSession.close();
        
                
    }

}

package test.com.smacul.demo.service.serviceImpl; 

import com.smacul.demo.dao.IndexMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** 
* IndexServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 24, 2019</pre> 
* @version 1.0 
*/ 
public class IndexServiceImplTest {

    @Autowired
    IndexMapper indexMapper;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: getLeftNavTags()
    *
    */
    @Test
    public void testGetLeftNavTags() throws Exception {
        //TODO: Test goes here...
        List<String> result = indexMapper.getLeftNavTags();
        System.out.println(result);
    }


} 

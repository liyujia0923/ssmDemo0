import com.bdqn.ssm4.entity.Tuser4;
import com.bdqn.ssm4.service.TuserService4;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 佳 on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TuserService4Test {
    @Resource
    private TuserService4 tuserService4;
    @Test
    public void login() throws Exception {
        Tuser4 tuser4 = new Tuser4();
        tuser4.setUserName("admin");
        tuser4.setPassword("abc");
        Tuser4 user = tuserService4.login(tuser4);
        System.out.println(user);

    }

    @Test
    public void queryAll() {
        PageInfo<Tuser4> pageInfo = tuserService4.queryAll(2, 2);
        List<Tuser4> list = pageInfo.getList();
        if (null != list) {
            for (Tuser4 tuser4 : list) {
                System.out.println(tuser4);
            }
        }
    }

}
package mybatis;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("id") Integer id);

    User getUserName(@Param("id") Integer id);
}

package tool;

import java.util.List;
import tool.Youth;

public interface YouthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Youth record);

    Youth selectByPrimaryKey(Integer id);

    List<Youth> selectAll();

    int updateByPrimaryKey(Youth record);
}
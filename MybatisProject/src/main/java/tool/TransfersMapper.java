package tool;

import java.util.List;
import tool.Transfers;

public interface TransfersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transfers record);

    Transfers selectByPrimaryKey(Integer id);

    List<Transfers> selectAll();

    int updateByPrimaryKey(Transfers record);
}
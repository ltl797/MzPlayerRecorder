package mapper;

import java.util.List;
import model.Transfers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TransfersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transfers record);

    Transfers selectByPrimaryKey(Integer id);

    List<Transfers> selectAll();

    int updateByPrimaryKey(Transfers record);

    List<Transfers> selectByPlayerId(Integer playerId);
    Transfers selectLastedByPlayerId(Integer playerId);

    int updateByPlayerId(Transfers record);

    List<Transfers> selectByRowBounds(RowBounds rowBounds);

    List<Transfers> selectByAbility(@Param("low") Transfers low, @Param("high") Transfers high);

}
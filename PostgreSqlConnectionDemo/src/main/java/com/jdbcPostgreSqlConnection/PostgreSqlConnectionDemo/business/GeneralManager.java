
package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.utilities.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneralManager<T> implements GeneralService<T> {
    @Autowired
    private CastService castService;

    public GeneralManager(CastService castService) {
        this.castService = castService;
    }
    @Override
    public List<T> getObjectList(String query){
        List<T> tList = castService.getObjectList(query);
        return tList;
    }

    @Override
    public Object getObjectById(String query) {
        return castService.getObjectById(query);
    }
}

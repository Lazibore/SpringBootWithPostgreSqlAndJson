
package com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.business;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.result.*;
import com.jdbcPostgreSqlConnection.PostgreSqlConnectionDemo.core.utilities.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GeneralManager<T> implements GeneralService<T> {

    private CastService castService;
    @Autowired
    public GeneralManager(CastService castService) {
        this.castService = castService;
    }
    @Override
    public DataResult<List<T>>  getObjectList(String query){
        List<T> tList = castService.getObjectList(query);
        return new SuccessDataResult<>("Listeleme basarili",tList);
    }

    @Override
    public DataResult<T> getObjectById(String query) {
        return new SuccessDataResult<>
                ("Basariyla Bulundu", (T) castService.getObjectById(query));
    }

    @Override
    public Result delObjectById(String query) {
           int rowsAffected= castService.deleteObjectById(query);
           String message="Silme islemi basarili";
           if (rowsAffected ==0)
           {
               message="Silme islemi basarisiz";
               return new ErrorResult(message);
           }
           else
               return new SuccesResult(message);


    }


}

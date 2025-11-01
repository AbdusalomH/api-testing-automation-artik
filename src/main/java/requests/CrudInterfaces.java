package requests;

import models.BaseModel;

import java.util.Map;
public interface CrudInterfaces {
    Object post(BaseModel baseModel);
    Object get();
    Object put(BaseModel baseModel);
    Object patch(BaseModel baseModel);
    Object delete(int id);
}

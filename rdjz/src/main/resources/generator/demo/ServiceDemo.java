package {{servicePackage}};

import gu.shoppingmall.interior.mapper.BaseMapper;
import {{mapperPackage}}.{{className}}Mapper;
import gu.shoppingmall.interior.service.BaseService;
import {{modelPackage}}.{{className}};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author {{author}}
 * @since {{nowTimeString}}
 * @version 1.0.0
 *
 */

public interface {{className}}Service extends BaseService<{{className}}> {
	
}

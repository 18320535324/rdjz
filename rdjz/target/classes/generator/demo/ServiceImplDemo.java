package {{actionPackage}};

import gu.shoppingmall.interior.service.BaseService;
import gu.shoppingmall.utils.log.LogUtil;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import {{servicePackage}}.{{className}}Service;
import {{classPackage}}.{{className}};


/**
 *
 * @author {{author}}
 * @since {{nowTimeString}}
 * @version 1.0.0
 *
 */
@Service("{{interfaceName}}Service")
public class {{className}}ServiceImpl extends BaseServiceImpl<{{className}}> {

    private static final Log logger = LogUtil.getLog({{className}}Action.class);
    
    @Autowired
    {{className}}Mapper mapper;

    @Override
    protected BaseMapper<{{className}}> getMapper() {
        return mapper;
    }
}


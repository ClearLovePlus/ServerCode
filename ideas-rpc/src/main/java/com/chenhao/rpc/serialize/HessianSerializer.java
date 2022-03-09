package com.chenhao.rpc.serialize;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @description: HessianSerializer序列化和反序列实现类
 * @author: chenhao
 * @date: 2022-2-7 14:57
 */
public class HessianSerializer extends Serialize {
    private static final Logger logger = LoggerFactory.getLogger(HessianSerializer.class);

    @Override
    public <T> byte[] serialize(T object) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output hs = new Hessian2Output(os);
        try {
            hs.writeObject(object);
            hs.flush();
            return os.toByteArray();
        } catch (IOException e) {
            logger.error("HessianSerializer serialize error",e);
            return null;
        }finally {
            try {
                hs.close();
            }catch (IOException e){
                logger.error("HessianSerializer serialize error",e);
            }
            try {
                os.close();
            } catch (IOException e) {
                logger.error("HessianSerializer serialize error",e);
            }
        }
    }

    @Override
    public <T> Object deserialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream is=new ByteArrayInputStream(bytes);
        Hessian2Input hi=new Hessian2Input(is);
        try {
            return hi.readObject();
        }catch (IOException e){
            logger.error("HessianSerializer deserialize error",e);
            return null;
        }finally {
            try {
                hi.close();
            } catch (IOException e) {
                logger.error("HessianSerializer deserialize error",e);
            }
            try {
                is.close();
            } catch (IOException e) {
                logger.error("HessianSerializer deserialize error",e);
            }
        }
    }
}

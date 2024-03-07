package com.situ.mallsdauweb.mapper;

import com.situ.mallsdauweb.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.situ.mallsdauweb.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-06-04
 */
public interface CartMapper extends BaseMapper<Cart> {
@Select("select   * from cart where member_id=#{memberId} and product_id=#{id}")
    Cart selectByMemberIdAndProductId(@Param("memberId") Integer memberId,@Param("id") Integer id);
   @Select("select cart.id,cart.amount,product.name productName,product.price,product.img_path from cart inner join product on cart.product_id=product.id where cart.member_id=#{id}")
    List<CartVO> cartList(Integer id);


    List<CartVO> selectCarts(String[] split);
}

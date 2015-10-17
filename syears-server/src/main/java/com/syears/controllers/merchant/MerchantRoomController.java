package com.syears.controllers.merchant;

import com.syears.commons.Pagination;
import com.syears.commons.ResponseConstants;
import com.syears.commons.vo.CollectionVO;
import com.syears.commons.vo.merchant.MerchantKitchenInfoVO;
import com.syears.commons.vo.merchant.MerchantResultVO;
import com.syears.commons.vo.merchant.MerchantUserVO;
import com.syears.controllers.support.Response;
import com.syears.controllers.support.Responses;
import com.syears.exceptions.KitchenInfoException;
import com.syears.services.merchant.CommentService;
import com.syears.services.merchant.MerchantKitchenService;
import com.syears.services.merchant.MerchantUsersService;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaowei on 15-8-25.
 */
@RestController
@Scope("prototype")
@RequestMapping(value = "/mr")
public class MerchantRoomController implements ResponseConstants {


    @Resource
    MerchantUsersService merchantUsersService;

    @Resource
    MerchantKitchenService merchantKitchenService;

    @Resource
    CommentService commentService;


    @RequestMapping(value = "/saveMr")
    public Response saveMerchantRoom(@RequestBody MerchantKitchenInfoVO mr) {
        MerchantKitchenInfoVO merchantKitchenInfo = new MerchantKitchenInfoVO();
        return Responses.SUCCESS().setPayload(merchantKitchenInfo);
    }


    @RequestMapping(value = "/getMrOne/{id}")
    public Response getMerchantOne(@PathVariable("id") String id) {
        MerchantKitchenInfoVO mk = merchantUsersService.mrFindById(id);
        MerchantUserVO mu = merchantUsersService.muFindById(id);
        //TODO 查询该商家评论数需要将静态sellerId改为动态
        long cc = commentService.commentCount("88888888");
        MerchantResultVO muk = new MerchantResultVO(mu, mk,cc);
        return Responses.SUCCESS().setPayload(muk);
    }


    @RequestMapping(value = "/getMrData", method = RequestMethod.GET)
    public Response getMerchantRoomData(@RequestParam double lng, @RequestParam double lat) throws KitchenInfoException {
        List<MerchantKitchenInfoVO> pager = merchantUsersService.pageList(1, 10);
//        }
        return Responses.SUCCESS().setPayload(pager);
    }


    @RequestMapping(value = "/getKitchenByName/{kitName}", method = RequestMethod.GET)
    public Response getKitchenByName(@PathVariable String kitName) {
        List<MerchantKitchenInfoVO> merchantKitchenInfoVOs = merchantUsersService.conditionalSearch(kitName);

        return Responses.SUCCESS().setPayload(merchantKitchenInfoVOs);
    }

    @RequestMapping(value = "/getGeographical", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getGeographical(@RequestBody Pagination p) {
        CollectionVO<MerchantKitchenInfoVO> merchantKitchenInfoVOs = null;
        try {
            merchantKitchenInfoVOs = merchantKitchenService.geographicalSearch(p);
            System.out.println("");
            return Responses.SUCCESS().setPayload(merchantKitchenInfoVOs);
        } catch (Exception e) {
            e.printStackTrace();
            return Responses.FAILED();
        }
    }
}

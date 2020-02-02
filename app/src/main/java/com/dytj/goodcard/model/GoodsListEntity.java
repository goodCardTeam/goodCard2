package com.dytj.goodcard.model;

import java.util.List;

/**
 * Created by MaRufei
 * on 2020-01-31.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class GoodsListEntity {

    /**
     * current_page : 1
     * data : [{"id":1,"data":{"category_id":"50011167","category_name":"羽绒服","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D8Xa%2FPFHXqxlw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1UCv%2FctrzKV%2Fedxs416Jy%2FNC2TKqEFvn7inXTIMRtDNDixYWk%2FmMjF4zY2heEKaR20HnbuuAZo1YuXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","commission_rate":"9.0","coupon_amount":"100","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","coupon_end_time":"1577807999000","coupon_info":"满179.00元减100元","coupon_remain_count":"95000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","coupon_start_fee":"179.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":[],"item_id":"602442927978","level_one_category_id":"30","level_one_category_name":"男装","nick":"富贵鸟男装旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/810959940/O1CN01TBNl6J2NIZTKmHxhe_!!0-item_pic.jpg","seller_id":"810959940","shop_title":"富贵鸟男装旗舰店","small_images":{"string":["//img.alicdn.com/i3/810959940/O1CN01Tbrc322NIZTNr32Rw_!!0-item_pic.jpg","//img.alicdn.com/i2/810959940/O1CN01J1G1Bw2NIZSEybBAg_!!810959940.jpg","//img.alicdn.com/i4/810959940/O1CN01dsN09w2NIZSQ8U1EZ_!!810959940.jpg","//img.alicdn.com/i1/810959940/O1CN01RZITSU2NIZTTCRkRh_!!810959940.jpg"]},"title":"富贵鸟冬季轻薄款羽绒服男短款青年潮帅气外套白鸭绒新款爆款中年","user_type":"1","volume":"275","zk_final_price":"179"},"zk_final_price":"179.00","commission_rate":"9.00","jifen":8.06,"yongjin":8.06},{"id":2,"data":{"category_id":"50050690","category_name":"咸鸭蛋","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D9Nk1tHXC%2F3Fw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1WGLFMKzQFX8%2BQkkrCX3tv5otYzDcQ4SzJrgjAxE6YN4til6G8YbNH%2BbgTOH4ejrYP0pdCMKLP8R8g9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e540%4001","commission_rate":"6.0","coupon_amount":"3","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=qxxuuOYl7uINfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u79uII22YzuVmrly%2B9LEIQxJplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qByJ6QvxnjbbSezpXOiZpPjIIlSVJitYgLAwTejofyVAIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e540%4001","coupon_end_time":"1577721599000","coupon_info":"满28.00元减3元","coupon_remain_count":"49000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=qxxuuOYl7uINfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u79uII22YzuVmrly%2B9LEIQxJplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qByJ6QvxnjbbSezpXOiZpPjIIlSVJitYgLAwTejofyVAIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e540%4001","coupon_start_fee":"28.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"注意：拍两件发40枚一箱","item_id":"584479913519","level_one_category_id":"50050359","level_one_category_name":"水产肉类/新鲜蔬果/熟食","nick":"三客游旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i3/4261356620/O1CN014lzMmX1ym0XCjrMU5_!!0-item_pic.jpg","seller_id":"4261356620","shop_title":"三客游旗舰店","small_images":{"string":["//img.alicdn.com/i2/4261356620/O1CN01QMiiOp1ym0Reu2Psv_!!0-item_pic.jpg","//img.alicdn.com/i3/4261356620/O1CN012p23EI1ym0T3GkYlN_!!4261356620.jpg","//img.alicdn.com/i4/4261356620/O1CN010SEnNk1ym0ROfyrXo_!!0-item_pic.jpg","//img.alicdn.com/i1/4261356620/O1CN01v61ANX1ym0T9T1EA0_!!4261356620.jpg"]},"title":"三客游20枚海鸭蛋咸鸭蛋正宗流油烤熟非高邮广西北海北部湾红树林","user_type":"1","volume":"1448","zk_final_price":"32.8"},"zk_final_price":"32.80","commission_rate":"6.00","jifen":0.98,"yongjin":0.98},{"id":3,"data":{"category_id":"50008882","category_name":"内裤","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DlfWWn6hmK4hw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1W6bViqFSerpn%2Bp9jTTSXyqC2TKqEFvn7inXTIMRtDNDtXMv50odryRpE96qHr0I%2BjWnPDO8SzLF%2BXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e541%4001","commission_rate":"9.0","coupon_amount":"15","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=RlSdIQ%2Fw1QcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7wPaUopY0YSvRHWLM%2B5pLfFplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oWf%2B02By3G%2B5abJBajvqfoNEY5m1cwr82VF1Gq0oQ7SH44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e541%4001","coupon_end_time":"1577721599000","coupon_info":"满26.00元减15元","coupon_remain_count":"73000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=RlSdIQ%2Fw1QcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7wPaUopY0YSvRHWLM%2B5pLfFplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oWf%2B02By3G%2B5abJBajvqfoNEY5m1cwr82VF1Gq0oQ7SH44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e541%4001","coupon_start_fee":"26.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"5条礼盒装 健康舒适透气 收藏加购优先发货","item_id":"599141240013","level_one_category_id":"1625","level_one_category_name":"女士内衣/男士内衣/家居服","nick":"贝丝绮内衣旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i3/887708928/O1CN01g0jElt2Fp4eXiV6qg_!!0-item_pic.jpg","seller_id":"887708928","shop_title":"贝丝绮内衣旗舰店","small_images":{"string":["//img.alicdn.com/i4/887708928/O1CN01MXxl752Fp4eOdg8os_!!887708928.jpg","//img.alicdn.com/i3/887708928/O1CN01uoTS9m2Fp4eOOMnw7_!!887708928.jpg","//img.alicdn.com/i1/887708928/O1CN01EvssVY2Fp4cYj8wvG_!!887708928.jpg","//img.alicdn.com/i1/887708928/O1CN01aTiiON2Fp4eRFmnGO_!!887708928.jpg"]},"title":"男士内裤男平角裤冰丝透气薄款潮流四角裤头底裤衩个性骚宽松大码","user_type":"1","volume":"3439","zk_final_price":"26.9"},"zk_final_price":"26.90","commission_rate":"9.00","jifen":1.21,"yongjin":1.21},{"id":4,"data":{"category_id":"125088021","category_name":"大豆分离蛋白","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D5ZJ5029eoXlw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1VRt5tchuRyAFCh9398SkPhOemaFM5tHHYxZyjQcbVDhcnjRDTsxzJ6hyrLoWiplaWME7FP5cZSU%2FvkMOsFDj1GvRn9s5lIr3k%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e542%4001","commission_rate":"10.5","coupon_amount":"100","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=xi8NvWJZgckNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xI8RjTEQK4fW1R96XTEXPtplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qKUfXmxp%2FvntzslR2odl6u8ljxwxWUTXJS4Osvzp%2FAuap75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e542%4001","coupon_end_time":"1577635199000","coupon_info":"满129.00元减100元","coupon_remain_count":"93000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=xi8NvWJZgckNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xI8RjTEQK4fW1R96XTEXPtplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qKUfXmxp%2FvntzslR2odl6u8ljxwxWUTXJS4Osvzp%2FAuap75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e542%4001","coupon_start_fee":"129.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"南京同仁堂 百年老字号 百姓身边的同仁堂","item_id":"603145866471","level_one_category_id":"50026800","level_one_category_name":"保健食品/膳食营养补充食品","nick":"乐家老铺旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i3/2201439551445/O1CN01JTYIp01MXqtSfvLbI_!!0-item_pic.jpg","seller_id":"2201439551445","shop_title":"乐家老铺旗舰店","small_images":{"string":["//img.alicdn.com/i3/2201439551445/O1CN01lDW0Ln1MXqtAw10m6_!!2201439551445.jpg","//img.alicdn.com/i2/2201439551445/O1CN01Wz6Ilh1MXqtNzkKxG_!!2201439551445.jpg","//img.alicdn.com/i4/2201439551445/O1CN01g8HtWQ1MXqsS2TeE5_!!2201439551445.jpg","//img.alicdn.com/i3/2201439551445/O1CN01C80FOR1MXqsKrQLPz_!!2201439551445.jpg"]},"title":"南京同仁堂蛋白粉乳清植物中老年人儿童高营养品白蛋白质粉免疫力","user_type":"1","volume":"301394","zk_final_price":"129.9"},"zk_final_price":"129.90","commission_rate":"10.50","jifen":6.82,"yongjin":6.82},{"id":5,"data":{"category_id":"50010539","category_name":"毛衣/针织衫","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D65QKJQhpUHFw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1Vaieb2Yi8bh%2BuDlg7YN5s8OemaFM5tHHYxZyjQcbVDhcnjRDTsxzJ6sZaAMA83JdmbELV%2BZvYjLfvkMOsFDj1GvRn9s5lIr3k%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e543%4001","commission_rate":"6.0","coupon_amount":"10","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=ShchRf7nSn8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u77%2FOWdnyXt0sttdTj8DmHY1plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8poK9zY0wRAh4grMJ76tAIG5JojRBZjb103L4l%2BQfBQhKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e543%4001","coupon_end_time":"1577721599000","coupon_info":"满29.00元减10元","coupon_remain_count":"85000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=ShchRf7nSn8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u77%2FOWdnyXt0sttdTj8DmHY1plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8poK9zY0wRAh4grMJ76tAIG5JojRBZjb103L4l%2BQfBQhKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e543%4001","coupon_start_fee":"29.0","coupon_start_time":"1577376000000","coupon_total_count":"100000","item_description":[],"item_id":"609385756250","level_one_category_id":"50008165","level_one_category_name":"童装/婴儿装/亲子装","nick":"vipmind童装旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/2206352712205/O1CN01Ht4VP21S9vu1lp9Sa_!!0-item_pic.jpg","seller_id":"2206352712205","shop_title":"vipmind童装旗舰店","small_images":{"string":["//img.alicdn.com/i3/2206352712205/O1CN018ookfn1S9vtvmARL5_!!2206352712205.jpg","//img.alicdn.com/i3/2206352712205/O1CN01XNTqrW1S9vtzpb0iD_!!2206352712205.jpg","//img.alicdn.com/i4/2206352712205/O1CN01VlXMTD1S9vtxjSB0G_!!2206352712205.jpg","//img.alicdn.com/i3/2206352712205/O1CN01EDS86J1S9vtyG2vXi_!!2206352712205.jpg"]},"title":"儿童针织衫男童婴儿套头打底衫宝宝加绒加厚圆领线衣女童毛衣冬装","user_type":"1","volume":"256","zk_final_price":"29.9"},"zk_final_price":"29.90","commission_rate":"6.00","jifen":0.9,"yongjin":0.9},{"id":6,"data":{"category_id":"50006846","category_name":"短袜/打底袜/丝袜/美腿袜","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3Dd5s1kGADVhBw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1WgU2QoYsuRUFWbQ7NsQvD1otYzDcQ4SzJrgjAxE6YN4uMeootrswwp4YJFdWe3t%2BmxDyCzXb7NLcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e544%4001","commission_rate":"6.0","coupon_amount":"10","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=UL2wO%2BA8zngNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7%2BM1%2FRG%2Fsx9Ffu0PfMq62ddplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8rwI%2F2EkmrA070An2z3lBk%2FHCk7YiPYL7snVG6ODhWN0AIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e544%4001","coupon_end_time":"1577635199000","coupon_info":"满25.00元减10元","coupon_remain_count":"44000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=UL2wO%2BA8zngNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7%2BM1%2FRG%2Fsx9Ffu0PfMq62ddplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8rwI%2F2EkmrA070An2z3lBk%2FHCk7YiPYL7snVG6ODhWN0AIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e544%4001","coupon_start_fee":"25.0","coupon_start_time":"1577376000000","coupon_total_count":"100000","item_description":"【街头潮袜】【日系ins风】【纯色百搭】","item_id":"603456065566","level_one_category_id":"1625","level_one_category_name":"女士内衣/男士内衣/家居服","nick":"creativecode旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/4003406273/O1CN01smpdt71wD56BPu96y_!!0-item_pic.jpg","seller_id":"4003406273","shop_title":"creativecode旗舰店","small_images":{"string":["//img.alicdn.com/i1/4003406273/O1CN017mzPup1wD55yA4irB_!!4003406273.jpg","//img.alicdn.com/i1/4003406273/O1CN01jMhALQ1wD55veOzHr_!!4003406273.jpg","//img.alicdn.com/i3/4003406273/O1CN01SUDyyW1wD55SCk419_!!4003406273.jpg","//img.alicdn.com/i1/4003406273/O1CN01V86P7a1wD55x9H70H_!!4003406273.jpg"]},"title":"袜子女中筒袜ins潮网红款可爱日系纯色棉袜春秋冬季款女士中长筒","user_type":"1","volume":"132028","zk_final_price":"25.9"},"zk_final_price":"25.90","commission_rate":"6.00","jifen":0.78,"yongjin":0.78},{"id":7,"data":{"category_id":"50013099","category_name":"枣类制品","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3Dt%2FprWDBOaVtw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1VyjKiUadHhtQMxQ3W61OrZotYzDcQ4SzJrgjAxE6YN4uMeootrswwplL8%2FlOcf%2BXSL0BY1F%2FF5Fsg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e545%4001","commission_rate":"6.0","coupon_amount":"5","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=HTZOPMZEndQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7zNBTRYoItCQ0XydCI3qUu5plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8r0ooyRFnxG%2F1LE5aUXhVvsc9JcZO1mrr%2B0mV69TIsn%2BwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e545%4001","coupon_end_time":"1577548799000","coupon_info":"满39.00元减5元","coupon_remain_count":"82000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=HTZOPMZEndQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7zNBTRYoItCQ0XydCI3qUu5plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8r0ooyRFnxG%2F1LE5aUXhVvsc9JcZO1mrr%2B0mV69TIsn%2BwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e545%4001","coupon_start_fee":"39.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":[],"item_id":"605149158724","level_one_category_id":"50002766","level_one_category_name":"零食/坚果/特产","nick":"舌里旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i3/3400390945/O1CN01T6NvcX1IqqrZ381dc_!!0-item_pic.jpg","seller_id":"3400390945","shop_title":"舌里旗舰店","small_images":{"string":["//img.alicdn.com/i2/3400390945/O1CN015tjF7t1IqqrHv8vRq_!!3400390945.jpg","//img.alicdn.com/i2/3400390945/O1CN01KAuKDj1IqqrBhzHzu_!!3400390945.jpg","//img.alicdn.com/i2/3400390945/O1CN01VqypnG1IqqrXXpvzF_!!3400390945.jpg","//img.alicdn.com/i2/3400390945/O1CN01BwLRXI1IqqrRWGtH0_!!3400390945.jpg"]},"title":"舌里红枣坚果年货礼盒装1288g 大枣夹核桃春节礼品干果零食大礼包","user_type":"1","volume":"124523","zk_final_price":"59.99"},"zk_final_price":"59.99","commission_rate":"6.00","jifen":1.8,"yongjin":1.8},{"id":8,"data":{"category_id":"50022677","category_name":"护手霜","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DuYaSIoIGT2Fw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1W%2Bwaq%2FF%2F1jZKw48xlld4RaotYzDcQ4SzJrgjAxE6YN4p%2BDr9Z8NFfthL9SlQafM4qzehHpVd7ax%2BXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e546%4001","commission_rate":"15.0","coupon_amount":"30","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=I32tlheaW6oNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u79wjPtuzEnmvqdmVVk4C1huUa0dffyDRWDu602pI%2Fsk5F279oPswX17IYBxvySrA3EXhdBTxFVZwQij9O%2FVxkLgaKtZxYX6VwkGHJQMlU5AI9xZbo9oTsfR2CbwHQEkne2UFFgz3RBVH&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e546%4001","coupon_end_time":"1577635199000","coupon_info":"满39.00元减30元","coupon_remain_count":"63000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=I32tlheaW6oNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u79wjPtuzEnmvqdmVVk4C1huUa0dffyDRWDu602pI%2Fsk5F279oPswX17IYBxvySrA3EXhdBTxFVZwQij9O%2FVxkLgaKtZxYX6VwkGHJQMlU5AI9xZbo9oTsfR2CbwHQEkne2UFFgz3RBVH&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e546%4001","coupon_start_fee":"39.0","coupon_start_time":"1577376000000","coupon_total_count":"100000","item_description":"关爱父母  草本配方 用的放心 效果好！","item_id":"42045934495","level_one_category_id":"50025705","level_one_category_name":"洗护清洁剂/卫生巾/纸/香薰","nick":"萃肌蓝居家日用专营店","pict_url":"//img.alicdn.com/bao/uploaded/i2/2100027363/O1CN015fZZuJ24GInhCxTFx_!!0-item_pic.jpg","seller_id":"2100027363","shop_title":"萃肌蓝居家日用专营店","small_images":{"string":["//img.alicdn.com/i2/2100027363/O1CN01FRWVGT24GInf3vKD3_!!2100027363.jpg","//img.alicdn.com/i1/2100027363/O1CN011IqmJz24GInrmTrRc_!!2100027363.jpg","//img.alicdn.com/i1/2100027363/O1CN01MBE33924GIoCTbnxB_!!2100027363.jpg","//img.alicdn.com/i4/2100027363/O1CN01W6nk3W24GInrmTKCF_!!2100027363.jpg"]},"title":"脚后跟干裂龟裂冻疮膏防裂皲裂开裂护手足裂口愈合修复马油霜男女","user_type":"1","volume":"85087","zk_final_price":"39.9"},"zk_final_price":"39.90","commission_rate":"15.00","jifen":2.99,"yongjin":2.99},{"id":9,"data":{"category_id":"125048022","category_name":"维生素E/小麦胚芽油","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DDNvigleLeR5w4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1U4Zt8CFFIvWnbRWZajLnLOC2TKqEFvn7inXTIMRtDNDtdnRNr3Ed%2BzEgpq3ex1eMpbnqQpNnz5FOXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e547%4001","commission_rate":"15.0","coupon_amount":"25","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=2Q%2FL1sBnbkINfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u753rlbg6kz1CRbkCVJumWC9plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8purfdyfCUOfSGAtxlEOZmnVEuGadU9i8yCu%2F14iORfTn44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e547%4001","coupon_end_time":"1577635199000","coupon_info":"满39.00元减25元","coupon_remain_count":"93000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=2Q%2FL1sBnbkINfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u753rlbg6kz1CRbkCVJumWC9plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8purfdyfCUOfSGAtxlEOZmnVEuGadU9i8yCu%2F14iORfTn44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e547%4001","coupon_start_fee":"39.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":[],"item_id":"607286310296","level_one_category_id":"50026800","level_one_category_name":"保健食品/膳食营养补充食品","nick":"众久旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i1/688040957/O1CN01Hnn4cC1IwLc9gxF5r_!!688040957-0-pixelsss.jpg","seller_id":"688040957","shop_title":"众久旗舰店","small_images":{"string":["//img.alicdn.com/i4/688040957/O1CN01kI153f1IwLbkNL7PB_!!0-item_pic.jpg","//img.alicdn.com/i2/688040957/O1CN01MU5oXd1IwLbWvb5Lp_!!688040957.png","//img.alicdn.com/i4/688040957/O1CN01ZtjG0N1IwLbZ3TbVu_!!688040957.jpg","//img.alicdn.com/i2/688040957/O1CN01Z0PAwA1IwLbWfJNW0_!!688040957.jpg"]},"title":"仁和 天然维生素e维e软胶囊ve内服外用面部外涂脸脸部油搭c片含片","user_type":"1","volume":"56837","zk_final_price":"39.6"},"zk_final_price":"39.60","commission_rate":"15.00","jifen":2.97,"yongjin":2.97},{"id":10,"data":{"category_id":"50024980","category_name":"香皂","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D5u7by%2F%2FttnZw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1VSx9VuafmLcZNcJmSwywBpotYzDcQ4SzJrgjAxE6YN4uMeootrswwpdEwQbWzo9yq%2Fr6wCbDdOGMg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e548%4001","commission_rate":"21.0","coupon_amount":"30","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=dEqW5f1%2BSkQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7wyg5wHrMyTJJTRvuPCF73hplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8poYh4LeY1jJajQQQOUMNQTAylPWD0jkVwWy3WKptCqkQIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e548%4001","coupon_end_time":"1577635199000","coupon_info":"满39.00元减30元","coupon_remain_count":"58000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=dEqW5f1%2BSkQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7wyg5wHrMyTJJTRvuPCF73hplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8poYh4LeY1jJajQQQOUMNQTAylPWD0jkVwWy3WKptCqkQIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e548%4001","coupon_start_fee":"39.0","coupon_start_time":"1577376000000","coupon_total_count":"100000","item_description":"除螨虫祛痘神皂！买2送2 送同款加送起泡网","item_id":"601135755047","level_one_category_id":"50025705","level_one_category_name":"洗护清洁剂/卫生巾/纸/香薰","nick":"滋韵堂旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/2187138540/O1CN01rK7nXC2CxMyUk3gVf_!!0-item_pic.jpg","seller_id":"2187138540","shop_title":"滋韵堂旗舰店","small_images":{"string":["//img.alicdn.com/i1/2187138540/O1CN016tGnMa2CxMxNWW12r_!!2187138540.jpg","//img.alicdn.com/i1/2187138540/O1CN01n9cWsw2CxMxvz96Pb_!!0-item_pic.jpg","//img.alicdn.com/i3/2187138540/O1CN01Gi8fOk2CxMxKyln9d_!!2187138540.jpg","//img.alicdn.com/i1/2187138540/O1CN01xNZyCj2CxMxFPTyPM_!!2187138540.jpg"]},"title":"仁和祛痘除螨皂硫磺杀菌全身背面部深层清洁男士去螨虫洗脸香皂女","user_type":"1","volume":"91089","zk_final_price":"39.9"},"zk_final_price":"39.90","commission_rate":"21.00","jifen":4.19,"yongjin":4.19},{"id":11,"data":{"category_id":"50010399","category_name":"(文胸-内裤)套装","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DUdmm0MFJFgZw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1WfwB%2FgpWdoCCwnMp%2FN1FU%2BotYzDcQ4SzJrgjAxE6YN4uMeootrswwpKcl8HJePHh3Oy3hUvWFa1sg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e549%4001","commission_rate":"9.0","coupon_amount":"600","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=x9qxSgiHjhQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xrUHOu9r%2BntPHBgyfEFI5Zplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8o8xNsHt4NCtjoMflZ34ouTqmHbgGqIdl95DqZ9rYuFvwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e549%4001","coupon_end_time":"1577980799000","coupon_info":"满639.00元减600元","coupon_remain_count":"92000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=x9qxSgiHjhQNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xrUHOu9r%2BntPHBgyfEFI5Zplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8o8xNsHt4NCtjoMflZ34ouTqmHbgGqIdl95DqZ9rYuFvwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e549%4001","coupon_start_fee":"639.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":[],"item_id":"608786633672","level_one_category_id":"50022517","level_one_category_name":"孕妇装/孕产妇用品/营养","nick":"先纳莎旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i1/3941301603/O1CN018s0M7F1NiDTDCqTjl_!!0-item_pic.jpg","seller_id":"3941301603","shop_title":"先纳莎旗舰店","small_images":{"string":["//img.alicdn.com/i1/3941301603/O1CN01Jxf2Dv1NiDTKcSQsR_!!3941301603.jpg","//img.alicdn.com/i4/3941301603/O1CN01E8QgcF1NiDTKqydid_!!3941301603.jpg","//img.alicdn.com/i2/3941301603/O1CN01eiKN3v1NiDTOQXAE7_!!3941301603.jpg","//img.alicdn.com/i2/3941301603/O1CN01XfjrJ71NiDT7YX1Uf_!!3941301603.jpg"]},"title":"XianNasha先纳莎【双旦礼遇】聚拢无钢圈舒适调整内衣女文胸无痕","user_type":"1","volume":"26549","zk_final_price":"659.9"},"zk_final_price":"659.90","commission_rate":"9.00","jifen":29.7,"yongjin":29.7},{"id":12,"data":{"category_id":"50013099","category_name":"枣类制品","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DDDbh0PJVGEtw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1X5nl39NWgY1oYnPV3twT%2BwotYzDcQ4SzJrgjAxE6YN4nkCuh0JaPO%2FzJV%2BFKoq6HUuTA5OXPSYZcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54a%4001","commission_rate":"6.0","coupon_amount":"3","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=iKU73o%2BRYKkNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xBDozpElR1Ue%2BBPF3PJ6vpplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qtg6Q6Dxcm1RG3eMETe7F6CRxmV1OmpHj98NLMbtJy%2BAIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54a%4001","coupon_end_time":"1577980799000","coupon_info":"满15.00元减3元","coupon_remain_count":"28200","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=iKU73o%2BRYKkNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7xBDozpElR1Ue%2BBPF3PJ6vpplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qtg6Q6Dxcm1RG3eMETe7F6CRxmV1OmpHj98NLMbtJy%2BAIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54a%4001","coupon_start_fee":"15.0","coupon_start_time":"1577376000000","coupon_total_count":"30000","item_description":"3斤量贩装 核小肉厚味甜适合干吃","item_id":"542716445930","level_one_category_id":"50002766","level_one_category_name":"零食/坚果/特产","nick":"三叶果旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/1895474895/O1CN01XUWvPP1m1xHOfp8mR_!!0-item_pic.jpg","seller_id":"1895474895","shop_title":"三叶果旗舰店","small_images":{"string":["//img.alicdn.com/i1/1895474895/TB2bxG7pz7nBKNjSZLeXXbxCFXa_!!1895474895.jpg","//img.alicdn.com/i3/1895474895/O1CN01OmgdxZ1m1xEeBQZ0O_!!1895474895.jpg","//img.alicdn.com/i4/1895474895/TB2YayepHArBKNjSZFLXXc_dVXa_!!1895474895.jpg","//img.alicdn.com/i4/1895474895/TB2hMfSptcnBKNjSZR0XXcFqFXa_!!1895474895.png"]},"title":"三叶果新疆红枣若羌灰枣2500g一级免洗新货5斤装甜过和田大枣零食","user_type":"1","volume":"258306","zk_final_price":"15.9"},"zk_final_price":"15.90","commission_rate":"6.00","jifen":0.48,"yongjin":0.48},{"id":13,"data":{"category_id":"50016429","category_name":"豆类制品","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D8Z0w4AqaSWFw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1WhJSJkY3CP4eLIo5k%2F%2BU0notYzDcQ4SzJrgjAxE6YN4uMeootrswwp5k62IZVLxFcuTA5OXPSYZcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54b%4001","commission_rate":"6.0","coupon_amount":"3","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=lYJJ49%2BPOMcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7yI7s2bFXGSCrWqvR60Rixhplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ogl863zU%2FsQxfl7TDgiDI4kmZdihqB4jm4tiVCHZ%2Br1AIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54b%4001","coupon_end_time":"1577721599000","coupon_info":"满10.00元减3元","coupon_remain_count":"100000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=lYJJ49%2BPOMcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7yI7s2bFXGSCrWqvR60Rixhplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ogl863zU%2FsQxfl7TDgiDI4kmZdihqB4jm4tiVCHZ%2Br1AIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54b%4001","coupon_start_fee":"10.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"新货 香酥可口","item_id":"604274472030","level_one_category_id":"50002766","level_one_category_name":"零食/坚果/特产","nick":"小糖屋食品专营店","pict_url":"//img.alicdn.com/bao/uploaded/i1/2452239677/O1CN01V1rGeJ2LM7IzaJh7G_!!0-item_pic.jpg","seller_id":"2452239677","shop_title":"小糖屋食品专营店","small_images":{"string":["//img.alicdn.com/i1/2452239677/O1CN01gwRpLB2LM7HzGhAmW_!!2452239677.png","//img.alicdn.com/i1/2452239677/O1CN01vnz0wF2LM7I79NLjS_!!2452239677.jpg","//img.alicdn.com/i3/2452239677/O1CN01BBwHwp2LM7I6yuoeE_!!2452239677.jpg","//img.alicdn.com/i3/2452239677/O1CN01nKi1mn2LM7I7scIF6_!!2452239677.png"]},"title":"蒜香青豆豌豆500g独立小包装零食批发整箱炒货散装豆类休闲食品","user_type":"1","volume":"69538","zk_final_price":"15.9"},"zk_final_price":"15.90","commission_rate":"6.00","jifen":0.48,"yongjin":0.48},{"id":14,"data":{"category_id":"50006846","category_name":"短袜/打底袜/丝袜/美腿袜","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DOIYsYdV%2BH%2B1w4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1VCU8UkiNlITdhlStIu%2BmOUotYzDcQ4SzJrgjAxE6YN4uMeootrswwpSdLOZmQlBqP9pElIsXItYcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54c%4001","commission_rate":"9.0","coupon_amount":"40","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=0C74X2WhiPYNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7zhdelsFZxJUosuAsikejytplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8pw%2F8B2pO1PUAcq2P5BesFc38Y34QL6H7NeIOjwzD6%2BfwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54c%4001","coupon_end_time":"1577807999000","coupon_info":"满99.00元减40元","coupon_remain_count":"100000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=0C74X2WhiPYNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u7zhdelsFZxJUosuAsikejytplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8pw%2F8B2pO1PUAcq2P5BesFc38Y34QL6H7NeIOjwzD6%2BfwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54c%4001","coupon_start_fee":"99.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"逼真自然-30天无理由退换货-送运费险","item_id":"603836824367","level_one_category_id":"1625","level_one_category_name":"女士内衣/男士内衣/家居服","nick":"宝娜斯1985内衣旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i1/2977116562/O1CN01Q2TPCm1yLRYS59bgP_!!0-item_pic.jpg","seller_id":"2977116562","shop_title":"宝娜斯1985内衣旗舰店","small_images":{"string":["//img.alicdn.com/i4/2977116562/O1CN01zx9oCS1yLRXzX8DPN_!!0-item_pic.jpg","//img.alicdn.com/i3/2977116562/O1CN013tCejn1yLRYC63PIn_!!2977116562.jpg","//img.alicdn.com/i4/2977116562/O1CN01ELpYcJ1yLRXuti1Eg_!!2977116562.jpg","//img.alicdn.com/i4/2977116562/O1CN01xXIk4M1yLRXsNpfgf_!!2977116562.jpg"]},"title":"宝娜斯光腿神器丝袜女秋冬款加绒加厚双层裸感超自然透肉打底裤女","user_type":"1","volume":"16394","zk_final_price":"99"},"zk_final_price":"99.00","commission_rate":"9.00","jifen":4.46,"yongjin":4.46},{"id":15,"data":{"category_id":"50012724","category_name":"水彩笔","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D%2FOhPKggXnyhw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1VunXGWDJigAbuSiAWE52m0OemaFM5tHHYxZyjQcbVDhcnjRDTsxzJ68mmvjJlml9NG9Tyq23isNfvkMOsFDj1GvRn9s5lIr3k%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54d%4001","commission_rate":"9.0","coupon_amount":"20","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=ei%2BCNZBrZZ8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u71ErFpo%2FyYCi6N4S2BVlaChplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ptVAGBknBNJMVtyNuLd2kemGFuuaEG9pLjYsMPQY%2FsyKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54d%4001","coupon_end_time":"1577721599000","coupon_info":"满34.00元减20元","coupon_remain_count":"99233","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=ei%2BCNZBrZZ8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u71ErFpo%2FyYCi6N4S2BVlaChplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ptVAGBknBNJMVtyNuLd2kemGFuuaEG9pLjYsMPQY%2FsyKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54d%4001","coupon_start_fee":"34.0","coupon_start_time":"1577116800000","coupon_total_count":"100000","item_description":[],"item_id":"603543704800","level_one_category_id":"50018004","level_one_category_name":"文具电教/文化用品/商务用品","nick":"柏彩旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/2206571150182/O1CN01lkJKUt1DDOepOuM8q_!!0-item_pic.jpg","seller_id":"2206571150182","shop_title":"柏彩旗舰店","small_images":{"string":["//img.alicdn.com/i4/2206571150182/O1CN01cZlu1b1DDOe9I4PCQ_!!2206571150182.jpg","//img.alicdn.com/i1/2206571150182/O1CN01gy8G9i1DDOe8JvpTD_!!2206571150182.jpg","//img.alicdn.com/i1/2206571150182/O1CN01mTWpcF1DDOeBOONGk_!!2206571150182.jpg","//img.alicdn.com/i3/2206571150182/O1CN01kK48oF1DDOeEMvFMi_!!2206571150182.jpg"]},"title":"柏彩水彩笔粉饼绘画礼盒学生绘画用品儿童绘画套装98件套 水彩笔蜡笔绘画套装礼盒","user_type":"1","volume":"4409","zk_final_price":"36.9"},"zk_final_price":"36.90","commission_rate":"9.00","jifen":1.66,"yongjin":1.66},{"id":16,"data":{"category_id":"127684027","category_name":"破壁机","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DAFMtL7cFLNpw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1X%2FqCaZgkW0HgQ9O5O38mFVotYzDcQ4SzJrgjAxE6YN4vdyyq99pcKlaG62qxEE6hEeicU2M%2FEKrcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54e%4001","commission_rate":"9.0","coupon_amount":"320","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=fcvstpt2R4kNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u78EoJ941%2Fyw9rWf3idd8whRplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qSeecEQHBG2I1rC2ncHbpZzVl7f7ozMQ%2FAgi2usflorgIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54e%4001","coupon_end_time":"1577635199000","coupon_info":"满599.00元减320元","coupon_remain_count":"97000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=fcvstpt2R4kNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u78EoJ941%2Fyw9rWf3idd8whRplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8qSeecEQHBG2I1rC2ncHbpZzVl7f7ozMQ%2FAgi2usflorgIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54e%4001","coupon_start_fee":"599.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"爆款！限时5折秒杀到手299！送1年只换不修","item_id":"576893850262","level_one_category_id":"50012082","level_one_category_name":"厨房电器","nick":"现代拉迪古恩专卖店","pict_url":"//img.alicdn.com/bao/uploaded/i2/3295794954/O1CN017bcbEk1mSygrmASDv_!!0-item_pic.jpg","seller_id":"3295794954","shop_title":"现代拉迪古恩专卖店","small_images":{"string":["//img.alicdn.com/i4/3295794954/O1CN01gO0tO41mSyf8kFmLo_!!3295794954.jpg","//img.alicdn.com/i4/3295794954/O1CN01oBbpz11mSyaqSetYB_!!3295794954.jpg","//img.alicdn.com/i3/3295794954/O1CN01j5DeUd1mSyfHVdfv8_!!3295794954.jpg","//img.alicdn.com/i1/3295794954/O1CN01NuAXC41mSyf4p8w58_!!3295794954.jpg"]},"title":"韩国现代破壁机家用豆浆多功能小型全自动加热辅食料理养生机免滤","user_type":"1","volume":"4699","zk_final_price":"599"},"zk_final_price":"599.00","commission_rate":"9.00","jifen":26.96,"yongjin":26.96},{"id":17,"data":{"category_id":"50012546","category_name":"湿巾","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3Dqn8h%2BKfV%2BjVw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1Xwzlb4jH3y6ml3dTxaFBUFOemaFM5tHHYxZyjQcbVDhcnjRDTsxzJ6oCe7Y2rnyUy3nJaPL8NiWPvkMOsFDj1GvRn9s5lIr3k%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54f%4001","commission_rate":"6.0","coupon_amount":"10","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=spct8FFuKBcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u74ZMRy8%2FveioHrYVjbfDNjtplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8rlpmHRg0gF3clkd9m0SU5gipsoN3TMJjN4de1o8hs%2BbKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54f%4001","coupon_end_time":"1577635199000","coupon_info":"满19.00元减10元","coupon_remain_count":"71000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=spct8FFuKBcNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u74ZMRy8%2FveioHrYVjbfDNjtplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8rlpmHRg0gF3clkd9m0SU5gipsoN3TMJjN4de1o8hs%2BbKp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e54f%4001","coupon_start_fee":"19.0","coupon_start_time":"1577376000000","coupon_total_count":"100000","item_description":"RO纯水.无香味.不掉毛.耐拉扯.植物棉湿巾","item_id":"599196980784","level_one_category_id":"50014812","level_one_category_name":"婴童用品","nick":"木木屋奥洁专卖店","pict_url":"//img.alicdn.com/bao/uploaded/i3/2205214433376/O1CN01ilTyN01aoFh0oZhVj_!!0-item_pic.jpg","seller_id":"2205214433376","shop_title":"木木屋奥洁专卖店","small_images":{"string":["//img.alicdn.com/i4/2205214433376/O1CN01GyFuyH1aoFfPyGxVA_!!2205214433376.jpg","//img.alicdn.com/i1/2205214433376/O1CN01nYKluW1aoFfOVZhqC_!!2205214433376.jpg","//img.alicdn.com/i2/2205214433376/O1CN01jW3le51aoFfRGJgcN_!!2205214433376.jpg","//img.alicdn.com/i2/2205214433376/O1CN01skcLiS1aoFfHzn9Ln_!!2205214433376.jpg"]},"title":"木木屋湿巾婴儿手口屁专用大包装特价80抽5大包家庭实惠装湿纸巾","user_type":"1","volume":"111567","zk_final_price":"19.98"},"zk_final_price":"19.98","commission_rate":"6.00","jifen":0.6,"yongjin":0.6},{"id":18,"data":{"category_id":"50012772","category_name":"睡衣/家居服套装","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DDXgezogilVZw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1UHavl%2FAoKM%2FXDUQr69B0D%2BOemaFM5tHHYxZyjQcbVDhcnjRDTsxzJ6X%2BtFBr2PwuBDk4zHuIzYRvvkMOsFDj1GvRn9s5lIr3k%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e550%4001","commission_rate":"6.0","coupon_amount":"5","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=NW57t4TAKuANfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u775QK%2FeiQDagAobbipvG6q5plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oQG7tS1eXdyceMxpbqHEE8%2F3tpSQaBXicEN%2Fw5nmUoeqp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e550%4001","coupon_end_time":"1577635199000","coupon_info":"满29.00元减5元","coupon_remain_count":"96000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=NW57t4TAKuANfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u775QK%2FeiQDagAobbipvG6q5plj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oQG7tS1eXdyceMxpbqHEE8%2F3tpSQaBXicEN%2Fw5nmUoeqp75K7%2FyOr4JTNWSR3CwiY%3D&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e550%4001","coupon_start_fee":"29.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"反季冲量 亏本促销","item_id":"588560858870","level_one_category_id":"1625","level_one_category_name":"女士内衣/男士内衣/家居服","nick":"北极绒迎梦专卖店","pict_url":"//img.alicdn.com/bao/uploaded/i4/2200731212744/O1CN01GBbVOz1W8nNElULm1_!!0-item_pic.jpg","seller_id":"2200731212744","shop_title":"北极绒迎梦专卖店","small_images":{"string":["//img.alicdn.com/i1/2200731212744/O1CN01JBrmpG1W8nMWEL0CJ_!!2200731212744.jpg","//img.alicdn.com/i1/2200731212744/O1CN01EWtbM31W8nMAmaKz6_!!2200731212744.jpg","//img.alicdn.com/i4/2200731212744/O1CN01uPhaey1W8nM2PRT76_!!2200731212744.jpg","//img.alicdn.com/i4/2200731212744/O1CN01axJYXI1W8nMdnZCVn_!!2200731212744.jpg"]},"title":"北极绒睡衣女秋冬法兰绒家居服保暖珊瑚绒春秋季可爱情侣加厚套装","user_type":"1","volume":"45479","zk_final_price":"29"},"zk_final_price":"29.00","commission_rate":"6.00","jifen":0.87,"yongjin":0.87},{"id":19,"data":{"category_id":"50010513","category_name":"传统糕点","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3DssavWkIsMilw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1XbEFqw1qceK%2FhLa2X0Aa7EotYzDcQ4SzJrgjAxE6YN4iHEdUBcCdgWCRldRT%2B1iyj9pElIsXItYcg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e551%4001","commission_rate":"6.0","coupon_amount":"5","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=HAHUSzwS6EENfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u72l5sHYk2d5aa%2B7cRY2gtLFplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8p27C8hzGOzky1ymsy0%2F6V68iSF4EmJUAP2fZ12Bck8fwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e551%4001","coupon_end_time":"1577807999000","coupon_info":"满14.00元减5元","coupon_remain_count":"70400","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=HAHUSzwS6EENfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u72l5sHYk2d5aa%2B7cRY2gtLFplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8p27C8hzGOzky1ymsy0%2F6V68iSF4EmJUAP2fZ12Bck8fwIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e551%4001","coupon_start_fee":"14.0","coupon_start_time":"1577462400000","coupon_total_count":"80000","item_description":"无添加，早餐食品下午茶点，适合小孩孕妇","item_id":"593254408667","level_one_category_id":"50002766","level_one_category_name":"零食/坚果/特产","nick":"吴玉源旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i1/2874572834/O1CN014MAf9C1Wo11s2UFyj_!!2874572834-0-pixelsss.jpg","seller_id":"2874572834","shop_title":"吴玉源旗舰店","small_images":{"string":["//img.alicdn.com/i2/2874572834/O1CN01vzBMls1Wo11jfgPxP_!!2874572834.jpg","//img.alicdn.com/i1/2874572834/O1CN01zOKvFC1Wo10ouzbOZ_!!2874572834.jpg","//img.alicdn.com/i1/2874572834/O1CN01mKwwjv1Wo10l57Tqy_!!2874572834.jpg","//img.alicdn.com/i2/2874572834/O1CN01yKHFep1Wo10ly3IFU_!!2874572834.jpg"]},"title":"浙江特产传统糕点手工网红小吃早餐食品糯米糕桂花糕美食孕妇零食","user_type":"1","volume":"102849","zk_final_price":"14.88"},"zk_final_price":"14.88","commission_rate":"6.00","jifen":0.45,"yongjin":0.45},{"id":20,"data":{"category_id":"50012478","category_name":"抽纸","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D%2BtIYLgiXaEdw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1WQ%2B%2BlEXWEs6MiW9SX3Qe%2F7otYzDcQ4SzJrgjAxE6YN4uMeootrswwp0AglNa4Gb%2FdGkfSN0Mmc1Mg9fOUZrjc%2BIYULNg46oBA%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e552%4001","commission_rate":"6.0","coupon_amount":"3","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=gampqV3K4HwNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u70v8jX5p4MoBNs2Db80FTxxplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ptKkS8vvPxR5%2BiO3XsBZL6ix5qhr%2BX4W92aaZYvHOJtQIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e552%4001","coupon_end_time":"1577807999000","coupon_info":"满29.00元减3元","coupon_remain_count":"100000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=gampqV3K4HwNfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u70v8jX5p4MoBNs2Db80FTxxplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8ptKkS8vvPxR5%2BiO3XsBZL6ix5qhr%2BX4W92aaZYvHOJtQIau621gO82&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e552%4001","coupon_start_fee":"29.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":"珍珠压花  柔韧亲肤","item_id":"608659227934","level_one_category_id":"50025705","level_one_category_name":"洗护清洁剂/卫生巾/纸/香薰","nick":"植护旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/2219509495/O1CN01IJOqFA2K0lDcTPtff_!!0-item_pic.jpg","seller_id":"2219509495","shop_title":"植护旗舰店","small_images":{"string":["//img.alicdn.com/i3/2219509495/O1CN01HxyKxj2K0lDqmAW1D_!!2219509495.jpg","//img.alicdn.com/i3/2219509495/O1CN01Ro1bLV2K0lDV6RV5d_!!2219509495.jpg","//img.alicdn.com/i1/2219509495/O1CN01p3VxhL2K0lDVMt9or_!!2219509495.jpg","//img.alicdn.com/i1/2219509495/O1CN01yLAlM12K0lDoI4w9H_!!2219509495.jpg"]},"title":"植护餐巾纸抽纸家用卫生纸巾小包面巾纸婴儿原木整箱批实惠装40包","user_type":"1","volume":"112561","zk_final_price":"29.9"},"zk_final_price":"29.90","commission_rate":"6.00","jifen":0.9,"yongjin":0.9}]
     * first_page_url : http://112.74.127.99:5016/api/tbk/products?page=1
     * from : 1
     * last_page : 10
     * last_page_url : http://112.74.127.99:5016/api/tbk/products?page=10
     * next_page_url : http://112.74.127.99:5016/api/tbk/products?page=2
     * path : http://112.74.127.99:5016/api/tbk/products
     * per_page : 20
     * prev_page_url : null
     * to : 20
     * total : 197
     */

    private int current_page;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private String next_page_url;
    private String path;
    private int per_page;
    private Object prev_page_url;
    private int to;
    private int total;
    private List<DataBeanX> data;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public Object getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(Object prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * id : 1
         * data : {"category_id":"50011167","category_name":"羽绒服","click_url":"//s.click.taobao.com/t?e=m%3D2%26s%3D8Xa%2FPFHXqxlw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1UCv%2FctrzKV%2Fedxs416Jy%2FNC2TKqEFvn7inXTIMRtDNDixYWk%2FmMjF4zY2heEKaR20HnbuuAZo1YuXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","commission_rate":"9.0","coupon_amount":"100","coupon_click_url":"//uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","coupon_end_time":"1577807999000","coupon_info":"满179.00元减100元","coupon_remain_count":"95000","coupon_share_url":"//uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001","coupon_start_fee":"179.0","coupon_start_time":"1577462400000","coupon_total_count":"100000","item_description":[],"item_id":"602442927978","level_one_category_id":"30","level_one_category_name":"男装","nick":"富贵鸟男装旗舰店","pict_url":"//img.alicdn.com/bao/uploaded/i2/810959940/O1CN01TBNl6J2NIZTKmHxhe_!!0-item_pic.jpg","seller_id":"810959940","shop_title":"富贵鸟男装旗舰店","small_images":{"string":["//img.alicdn.com/i3/810959940/O1CN01Tbrc322NIZTNr32Rw_!!0-item_pic.jpg","//img.alicdn.com/i2/810959940/O1CN01J1G1Bw2NIZSEybBAg_!!810959940.jpg","//img.alicdn.com/i4/810959940/O1CN01dsN09w2NIZSQ8U1EZ_!!810959940.jpg","//img.alicdn.com/i1/810959940/O1CN01RZITSU2NIZTTCRkRh_!!810959940.jpg"]},"title":"富贵鸟冬季轻薄款羽绒服男短款青年潮帅气外套白鸭绒新款爆款中年","user_type":"1","volume":"275","zk_final_price":"179"}
         * zk_final_price : 179.00
         * commission_rate : 9.00
         * jifen : 8.06
         * yongjin : 8.06
         */

        private int id;
        private DataBean data;
        private String zk_final_price;
        private String commission_rate;
        private double jifen;
        private double yongjin;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getZk_final_price() {
            return zk_final_price;
        }

        public void setZk_final_price(String zk_final_price) {
            this.zk_final_price = zk_final_price;
        }

        public String getCommission_rate() {
            return commission_rate;
        }

        public void setCommission_rate(String commission_rate) {
            this.commission_rate = commission_rate;
        }

        public double getJifen() {
            return jifen;
        }

        public void setJifen(double jifen) {
            this.jifen = jifen;
        }

        public double getYongjin() {
            return yongjin;
        }

        public void setYongjin(double yongjin) {
            this.yongjin = yongjin;
        }

        public static class DataBean {
            /**
             * category_id : 50011167
             * category_name : 羽绒服
             * click_url : //s.click.taobao.com/t?e=m%3D2%26s%3D8Xa%2FPFHXqxlw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1UCv%2FctrzKV%2Fedxs416Jy%2FNC2TKqEFvn7inXTIMRtDNDixYWk%2FmMjF4zY2heEKaR20HnbuuAZo1YuXCtfVOE0WGxg5p7bh%2BFbQ%3D&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001
             * commission_rate : 9.0
             * coupon_amount : 100
             * coupon_click_url : //uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001
             * coupon_end_time : 1577807999000
             * coupon_info : 满179.00元减100元
             * coupon_remain_count : 95000
             * coupon_share_url : //uland.taobao.com/coupon/edetail?e=mLU3k1U%2FKN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0%2Bc5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b%2Bn3oRHM5v%2BiV10TOhVplj%2Fn412%2FD5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN%2FhsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3%2FSe53seAQX44d%2BzmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId%3AMAPI%401577506314%400b847693_0d67_16f4ab41824_e53f%4001
             * coupon_start_fee : 179.0
             * coupon_start_time : 1577462400000
             * coupon_total_count : 100000
             * item_description : []
             * item_id : 602442927978
             * level_one_category_id : 30
             * level_one_category_name : 男装
             * nick : 富贵鸟男装旗舰店
             * pict_url : //img.alicdn.com/bao/uploaded/i2/810959940/O1CN01TBNl6J2NIZTKmHxhe_!!0-item_pic.jpg
             * seller_id : 810959940
             * shop_title : 富贵鸟男装旗舰店
             * small_images : {"string":["//img.alicdn.com/i3/810959940/O1CN01Tbrc322NIZTNr32Rw_!!0-item_pic.jpg","//img.alicdn.com/i2/810959940/O1CN01J1G1Bw2NIZSEybBAg_!!810959940.jpg","//img.alicdn.com/i4/810959940/O1CN01dsN09w2NIZSQ8U1EZ_!!810959940.jpg","//img.alicdn.com/i1/810959940/O1CN01RZITSU2NIZTTCRkRh_!!810959940.jpg"]}
             * title : 富贵鸟冬季轻薄款羽绒服男短款青年潮帅气外套白鸭绒新款爆款中年
             * user_type : 1
             * volume : 275
             * zk_final_price : 179
             */

            private String category_id;
            private String category_name;
            private String click_url;
            private String commission_rate;
            private String coupon_amount;
            private String coupon_click_url;
            private String coupon_end_time;
            private String coupon_info;
            private String coupon_remain_count;
            private String coupon_share_url;
            private String coupon_start_fee;
            private String coupon_start_time;
            private String coupon_total_count;
            private String item_id;
            private String level_one_category_id;
            private String level_one_category_name;
            private String nick;
            private String pict_url;
            private String seller_id;
            private String shop_title;
            private SmallImagesBean small_images;
            private String title;
            private String user_type;
            private String volume;
            private String zk_final_price;
//            private String item_description;

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getClick_url() {
                return click_url;
            }

            public void setClick_url(String click_url) {
                this.click_url = click_url;
            }

            public String getCommission_rate() {
                return commission_rate;
            }

            public void setCommission_rate(String commission_rate) {
                this.commission_rate = commission_rate;
            }

            public String getCoupon_amount() {
                return coupon_amount;
            }

            public void setCoupon_amount(String coupon_amount) {
                this.coupon_amount = coupon_amount;
            }

            public String getCoupon_click_url() {
                return coupon_click_url;
            }

            public void setCoupon_click_url(String coupon_click_url) {
                this.coupon_click_url = coupon_click_url;
            }

            public String getCoupon_end_time() {
                return coupon_end_time;
            }

            public void setCoupon_end_time(String coupon_end_time) {
                this.coupon_end_time = coupon_end_time;
            }

            public String getCoupon_info() {
                return coupon_info;
            }

            public void setCoupon_info(String coupon_info) {
                this.coupon_info = coupon_info;
            }

            public String getCoupon_remain_count() {
                return coupon_remain_count;
            }

            public void setCoupon_remain_count(String coupon_remain_count) {
                this.coupon_remain_count = coupon_remain_count;
            }

            public String getCoupon_share_url() {
                return coupon_share_url;
            }

            public void setCoupon_share_url(String coupon_share_url) {
                this.coupon_share_url = coupon_share_url;
            }

            public String getCoupon_start_fee() {
                return coupon_start_fee;
            }

            public void setCoupon_start_fee(String coupon_start_fee) {
                this.coupon_start_fee = coupon_start_fee;
            }

            public String getCoupon_start_time() {
                return coupon_start_time;
            }

            public void setCoupon_start_time(String coupon_start_time) {
                this.coupon_start_time = coupon_start_time;
            }

            public String getCoupon_total_count() {
                return coupon_total_count;
            }

            public void setCoupon_total_count(String coupon_total_count) {
                this.coupon_total_count = coupon_total_count;
            }

            public String getItem_id() {
                return item_id;
            }

            public void setItem_id(String item_id) {
                this.item_id = item_id;
            }

            public String getLevel_one_category_id() {
                return level_one_category_id;
            }

            public void setLevel_one_category_id(String level_one_category_id) {
                this.level_one_category_id = level_one_category_id;
            }

            public String getLevel_one_category_name() {
                return level_one_category_name;
            }

            public void setLevel_one_category_name(String level_one_category_name) {
                this.level_one_category_name = level_one_category_name;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getPict_url() {
                return pict_url;
            }

            public void setPict_url(String pict_url) {
                this.pict_url = pict_url;
            }

            public String getSeller_id() {
                return seller_id;
            }

            public void setSeller_id(String seller_id) {
                this.seller_id = seller_id;
            }

            public String getShop_title() {
                return shop_title;
            }

            public void setShop_title(String shop_title) {
                this.shop_title = shop_title;
            }

            public SmallImagesBean getSmall_images() {
                return small_images;
            }

            public void setSmall_images(SmallImagesBean small_images) {
                this.small_images = small_images;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getZk_final_price() {
                return zk_final_price;
            }

            public void setZk_final_price(String zk_final_price) {
                this.zk_final_price = zk_final_price;
            }

//            public String getItem_description() {
//                return item_description;
//            }
//
//            public void setItem_description(String item_description) {
//                this.item_description = item_description;
//            }

            public static class SmallImagesBean {
                private List<String> string;

                public List<String> getString() {
                    return string;
                }

                public void setString(List<String> string) {
                    this.string = string;
                }
            }
        }
    }
}

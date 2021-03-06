package serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AnalysisService;

import static org.junit.Assert.*;

/**
 * Created by Mark.W on 2017/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AnalysisServiceImplTest {

    @Autowired
    private AnalysisServiceImpl analysisService;

    @Test
    public void analyseKeyWords() throws Exception {
        String str = "原告吕惠玲诉称，原、被告于1998年4月协议离婚，婚生一女陈思、一子陈相均随原告生活，现被告每月给付陈相抚育费270元。原告目前没有住房、退休收入较低，实际生活存在很大困难，为了让孩子过上稳定正常的家庭生活，保障子女能健康成长，故起诉要求判准婚生子陈相由被告抚养。 被告陈华义辩称，我没有固定住所，经济条件不好，我经常上夜班，孩子与我无法正常生活、学习，我还有年老多病的母亲。我每月给孩子270元，原告退休费1000多元且有两套住房，有固定的住所，并且孩子已随其生活多年，女儿也有工作月工资700元且已独立生活，孩子随原告生活有利，故不同意孩子随我生活。 经审理查明，原、被告于1998年4月25日自愿协议离婚，婚生一女陈思（1982年出生）、一子陈相（1989年出生）均随原告生活，被告自2002年7月每月给付陈相抚育费270元。另查原告已退休月收入为730元，被告在职月平均收入为1427、34元，双方均无住处。现原告以实际生活存在很大困难，为了让孩子过上稳定正常的家庭生活，保障子女能健康成长为由起诉，要求变更孩子由被告抚养。庭审中，孩子陈相表示愿意随被告生活。 上述事实，有当事人当庭陈述，月收入证明，陈相证明、租房证明等证据证实，且上述证据均已质证，本院足以认定";
        System.out.println(analysisService.analyseKeyWords(str));
    }

    @Test
    public void recommendByKeywords() throws Exception {
    }

}
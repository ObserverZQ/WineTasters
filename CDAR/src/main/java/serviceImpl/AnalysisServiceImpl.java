package serviceImpl;

import dao.DocumentDao;
import entityPO.DocumentPO;
import entityVO.DocumentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnalysisService;
import util.ExtractKeyword;
import util.TransferHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2017/7/16.
 */
@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService{

    @Autowired
    private DocumentDao documentDao;
    
    @Override
    public String analyseKeyWords(String text) {
        ExtractKeyword extractKeyword = new ExtractKeyword();
        return extractKeyword.extractKeyword(text);
    }

    @Override
    public List<DocumentVO> recommendByKeywords(List<String> keywords) {
        List<DocumentPO> documentPOS = documentDao.getRecommendDocuments(keywords);
        return TransferHelper.transToDocumentVOList(documentPOS);
    }
}

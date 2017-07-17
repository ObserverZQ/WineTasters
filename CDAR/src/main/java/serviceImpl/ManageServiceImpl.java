package serviceImpl;

import dao.DocumentDao;
import entityPO.DocumentPO;
import entityVO.DocumentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ManageService;
import util.TransferHelper;

import java.io.File;
import java.util.List;

/**
 * Created by mac on 2017/7/16.
 */
@Service("manageService")
public class ManageServiceImpl implements ManageService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public boolean uploadDocument(File file) {
        return false;
    }

    @Override
    public boolean deleteDocument(Integer documentID) {
        return documentDao.deleteDocument(documentID);
    }

    @Override
    public List<DocumentVO> getDocuments(String rex, int max) {
        List<DocumentPO> documentPOS = documentDao.getDocuments(rex, max);
        return TransferHelper.transToDocumentVOList(documentPOS);
    }

    @Override
    public List<DocumentVO> getDocuments(int n, String category) {
        List<DocumentPO> documentPOS = documentDao.getDocuments(n, category);
        return TransferHelper.transToDocumentVOList(documentPOS);
    }
}

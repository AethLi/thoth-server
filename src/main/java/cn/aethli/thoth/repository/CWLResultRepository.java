package cn.aethli.thoth.repository;

import cn.aethli.thoth.entity.CWLResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-09-09 09:43
 */
public interface CWLResultRepository
    extends JpaRepository<CWLResult, String>, JpaSpecificationExecutor<CWLResult> {}

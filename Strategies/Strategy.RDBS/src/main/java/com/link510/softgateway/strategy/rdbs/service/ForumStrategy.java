package com.link510.softgateway.strategy.rdbs.service;

import com.link510.softgateway.core.data.rdbs.IForumStrategy;
import com.link510.softgateway.core.data.rdbs.repository.base.AttachmentRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumAttachmentRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumPostRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumPraiseRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumRepository;
import com.link510.softgateway.core.domain.base.AttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumAttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.domain.forums.ForumPostInfo;
import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;
import com.link510.softgateway.core.enums.categories.CateTypeEnums;
import com.link510.softgateway.core.helper.Map2Helper;
import com.link510.softgateway.core.helper.StringHelper;
import com.link510.softgateway.core.data.rdbs.IForumStrategy;
import com.link510.softgateway.core.data.rdbs.repository.base.AttachmentRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumAttachmentRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumPostRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumPraiseRepository;
import com.link510.softgateway.core.data.rdbs.repository.fourms.ForumRepository;
import com.link510.softgateway.core.domain.base.AttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumAttachmentInfo;
import com.link510.softgateway.core.domain.forums.ForumInfo;
import com.link510.softgateway.core.domain.forums.ForumPostInfo;
import com.link510.softgateway.core.domain.forums.ForumPraiseInfo;
import com.link510.softgateway.core.enums.categories.CateTypeEnums;
import com.link510.softgateway.core.helper.Map2Helper;
import com.link510.softgateway.core.helper.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component(value = "ForumStrategy")
public class ForumStrategy extends RDBSService implements IForumStrategy {





    @Autowired
    ForumRepository forumRepository;


    //region 论坛主表		 

    /**
     * 获得论坛主表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getForumCount(Specification<ForumInfo> condition) throws IOException {

        return forumRepository.count();
    }


    /**
     * 创建一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public ForumInfo createForum(ForumInfo forumInfo) throws IOException {

        return forumRepository.save(forumInfo);
    }


    /**
     * 更新一条论坛主表数据
     *
     * @param forumInfo 论坛主表模型
     **/
    @Override
    @Transactional
    public ForumInfo updateForum(ForumInfo forumInfo) throws IOException {

        if (forumInfo.getForumId() >= 1)
            return forumRepository.save(forumInfo);

        return forumInfo;

    }


    /**
     * 删除一条论坛主表数据
     *
     * @param forumId 论坛主表模型
     **/
    @Override
    @Transactional
    public void deleteForumByForumId(Integer forumId) throws IOException {

        forumRepository.deleteById(forumId);
    }

    /**
     * 批量删除一批论坛主表数据
     **/
    public void deleteForumByForumIdList(String forumIdlist) throws IOException {


    }

    /**
     * 获得论坛主表一条记录
     *
     * @param forumId forumid
     * @return 返回一条ForumInfo
     **/
    @Override
    @Transactional
    public ForumInfo getForumByForumId(Integer forumId) throws IOException {
        return forumRepository.findById(forumId).get();
    }


    /**
     * 获得论坛主表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumInfo
     **/
    @Override
    @Transactional
    public List<ForumInfo> getForumList(Specification<ForumInfo> condition, Sort sort) throws IOException {

        return forumRepository.findAll(condition, sort);

    }


    /**
     * 获得论坛主表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumInfo
     **/
    @Override
    @Transactional
    public Page<ForumInfo> getForumList(Integer pageSize, Integer pageNumber, Specification<ForumInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return forumRepository.findAll(condition, pageable);


    }

    /**
     * 获取附近的发贴信息列表
     *
     * @return
     */
    @Override
    @Transactional
    public List<ForumInfo> getAroundForumList(Integer cateId, double longitude, double latitude, double dis) throws IOException {

        Map2Helper.AroundPostion postion = Map2Helper.findNeighPosition(longitude, latitude, dis);


        Specification<ForumInfo> condition = new Specification<ForumInfo>() {
            @Override
            public Predicate toPredicate(Root<ForumInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();

                if (cateId >= 1) {
                    list.add(cb.equal(root.get("cateId").as(Integer.class), cateId));
                }


                //纬度大于最小范围值
                list.add(cb.gt(root.get("latitude").as(double.class), postion.getMinLatitude()));

                //纬度小于最大范围值
                list.add(cb.lt(root.get("latitude").as(double.class), postion.getMaxLatitude()));

                /**
                 * 经度大于小最小范围值
                 */
                list.add(cb.gt(root.get("longitude").as(double.class), postion.getMinLongitude()));


                /**
                 * 经度小于小最大范围值
                 */
                list.add(cb.lt(root.get("longitude").as(double.class), postion.getMaxLongitude()));


                list.add(cb.equal(root.get("isShow").as(Integer.class), 1));

                Predicate[] p = new Predicate[list.size()];

                query.where(cb.and(list.toArray(p)));


                return query.getGroupRestriction();
            }
        };


        Sort sort = new Sort(Sort.Direction.DESC, "forumId");

        return forumRepository.findAll(condition, sort);

    }

    /**
     * 获取圈子首页列表
     *
     * @return
     */
    @Override
    @Transactional
    public List<ForumInfo> getHomeForumList() throws IOException {

        return forumRepository.getHomeForumList();
    }

    /**
     * 获取圈子中发现物种列表
     *
     * @return
     */
    @Override
    @Transactional
    public List<ForumInfo> getFindSpecieHomeForumList() throws IOException {
        Integer typeId = CateTypeEnums.Specie.getTypeId();
        return getForumListByTypeId(typeId);
    }

    /**
     * 获取用户分类
     *
     * @param typeId
     * @return
     */
    @Override
    @Transactional
    public List<ForumInfo> getForumListByTypeId(Integer typeId) throws IOException {
        return forumRepository.getForumListByTypeId(typeId);
    }

    /**
     * 获取列表生成条件
     *
     * @param cateId
     * @return
     */
    public Specification<ForumInfo> getForumListCondition(Integer cateId) throws IOException {


        Specification<ForumInfo> condition = new Specification<ForumInfo>() {
            @Override
            public Predicate toPredicate(Root<ForumInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();

                if (cateId >= 1) {
                    list.add(cb.equal(root.get("cateId").as(Integer.class), cateId));
                }

                list.add(cb.equal(root.get("isShow").as(Integer.class), 1));

                Predicate[] p = new Predicate[list.size()];

                query.where(cb.and(list.toArray(p)));


                return query.getGroupRestriction();
            }
        };

        return condition;
    }

    /**
     * 获取后台列表生成条件
     *
     * @param cateId
     * @return
     */
    public Specification<ForumInfo> getAdminForumListCondition(Integer cateId, String keywords) throws IOException {

        Specification<ForumInfo> condition = new Specification<ForumInfo>() {
            @Override
            public Predicate toPredicate(Root<ForumInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();

                if (cateId >= 1) {
                    list.add(cb.equal(root.get("cateId").as(Integer.class), cateId));
                }

                if (StringHelper.IsNotNullOrWhiteSpace(keywords)) {

                    list.add(cb.like(root.get("body").as(String.class), "%" + keywords + "%"));
                }


                Predicate[] p = new Predicate[list.size()];

                query.where(cb.and(list.toArray(p)));


                return query.getGroupRestriction();
            }
        };

        return condition;
    }

    //endregion

    @Autowired
    ForumPostRepository forumPostRepository;

    //region 论坛回复		 

    /**
     * 获得论坛回复数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getForumPostCount(Specification<ForumPostInfo> condition) throws IOException {

        return forumPostRepository.count();
    }


    /**
     * 创建一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public ForumPostInfo createForumPost(ForumPostInfo forumpostInfo) throws IOException {

        ForumPostInfo postInfo = forumPostRepository.save(forumpostInfo);

        if (postInfo != null && postInfo.getPostId() >= 0) {

            forumRepository.updatePostCount(forumpostInfo.getForumId());
        }

        return postInfo;
    }


    /**
     * 更新一条论坛回复数据
     *
     * @param forumpostInfo 论坛回复模型
     **/
    @Override
    @Transactional
    public ForumPostInfo updateForumPost(ForumPostInfo forumpostInfo) throws IOException {

        if (forumpostInfo.getPostId() >= 1)
            return forumPostRepository.save(forumpostInfo);

        return forumpostInfo;

    }


    /**
     * 删除一条论坛回复数据
     *
     * @param postId 论坛回复模型
     **/
    @Override
    @Transactional
    public void deleteForumPostByPostId(Integer postId) throws IOException {

        forumPostRepository.deleteById(postId);
    }

    /**
     * 批量删除一批论坛回复数据
     **/
    public void deleteForumPostByPostIdList(String postIdlist) throws IOException {


    }

    /**
     * 获得论坛回复一条记录
     *
     * @param postId postid
     * @return 返回一条ForumPostInfo
     **/
    @Override
    @Transactional
    public ForumPostInfo getForumPostByPostId(Integer postId) throws IOException {
        return forumPostRepository.findById(postId).get();
    }


    /**
     * 获得论坛回复数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPostInfo
     **/
    @Override
    @Transactional
    public List<ForumPostInfo> getForumPostList(Specification<ForumPostInfo> condition, Sort sort) throws IOException {

        return forumPostRepository.findAll(condition, sort);

    }


    /**
     * 获得论坛回复数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPostInfo
     **/
    @Override
    @Transactional
    public Page<ForumPostInfo> getForumPostList(Integer pageSize, Integer pageNumber, Specification<ForumPostInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return forumPostRepository.findAll(condition, pageable);


    }

    /**
     * 获取指定的列表
     *
     * @param forumId    forumId
     * @param pageSize   每页条数
     * @param pageNumber 当前页数
     * @return
     */
    public Page<ForumPostInfo> getForumPostList(Integer forumId, Integer pageSize, Integer pageNumber) throws IOException {

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize);


        Specification<ForumPostInfo> condition = new Specification<ForumPostInfo>() {
            @Override
            public Predicate toPredicate(Root<ForumPostInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();

                if (forumId >= 0) {
                    list.add(cb.equal(root.get("forumId").as(Integer.class), forumId));
                }


                Predicate[] p = new Predicate[list.size()];

                query.where(cb.and(list.toArray(p)));


                return query.getGroupRestriction();
            }
        };


        return forumPostRepository.findAll(condition, pageable);

    }

    /**
     * 获取当前的楼层
     *
     * @param forumId 圈子id
     * @return
     */
    @Override
    @Transactional
    public Integer getForumPostLayer(Integer forumId) throws IOException {
        return Math.toIntExact(forumPostRepository.countByForumId(forumId));
    }

    //endregion

    @Autowired
    ForumAttachmentRepository forumAttachmentRepository;



    @Autowired
    AttachmentRepository attachmentRepository;

    //region 论坛附件表

    /**
     * 获得论坛附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getForumAttachmentCount(Specification<ForumAttachmentInfo> condition) throws IOException {

        return forumAttachmentRepository.count();
    }


    /**
     * 创建一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public ForumAttachmentInfo createForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException {

        return forumAttachmentRepository.save(forumattachmentInfo);
    }


    /**
     * 更新一条论坛附件表数据
     *
     * @param forumattachmentInfo 论坛附件表模型
     **/
    @Override
    @Transactional
    public ForumAttachmentInfo updateForumAttachment(ForumAttachmentInfo forumattachmentInfo) throws IOException {

        if (forumattachmentInfo.getAttachId() >= 1)
            return forumAttachmentRepository.save(forumattachmentInfo);

        return forumattachmentInfo;

    }



    /**
     * 删除一条论坛附件表数据
     *
     * @param attachId 论坛附件表模型
     **/
    @Override
    @Transactional
    public void deleteForumAttachmentByAttachId(Integer attachId) throws IOException {

        forumAttachmentRepository.deleteById(attachId);
    }

    /**
     * 批量删除一批论坛附件表数据
     **/
    public void deleteForumAttachmentByAttachIdList(String attachIdlist) throws IOException {


    }

    /**
     * 获得论坛附件表一条记录
     *
     * @param attachId attachid
     * @return 返回一条ForumAttachmentInfo
     **/
    @Override
    @Transactional
    public ForumAttachmentInfo getForumAttachmentByAttachId(Integer attachId) throws IOException {
        return forumAttachmentRepository.findById(attachId).get();
    }


    /**
     * 获得论坛附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumAttachmentInfo
     **/
    @Override
    @Transactional
    public List<ForumAttachmentInfo> getForumAttachmentList(Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException {

        return forumAttachmentRepository.findAll(condition, sort);

    }


    /**
     * 获得论坛附件表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumAttachmentInfo
     **/
    @Override
    @Transactional
    public Page<ForumAttachmentInfo> getForumAttachmentList(Integer pageSize, Integer pageNumber, Specification<ForumAttachmentInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return forumAttachmentRepository.findAll(condition, pageable);


    }

    /**
     * 获取贴子的附件列表
     *
     * @param forumId
     * @return
     */
    public List<AttachmentInfo> getAttachmentListByForumId(Integer forumId) throws IOException {

        return forumAttachmentRepository.getAttachmentListByForumId(forumId);
    }


    //endregion

    @Autowired
    ForumPraiseRepository forumPraiseRepository;

    //region 论坛点赞表		 

    /**
     * 获得论坛点赞表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    @Transactional
    public long getForumPraiseCount(Specification<ForumPraiseInfo> condition) throws IOException {

        return forumPraiseRepository.count();
    }


    /**
     * 创建一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    @Transactional
    public ForumPraiseInfo createForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException {

        ForumPraiseInfo praiseInfo = forumPraiseRepository.save(forumpraiseInfo);

        if (praiseInfo != null && praiseInfo.getPraiseId() >= 1) {
            forumRepository.updatePraiseCount(forumpraiseInfo.getForumId());
        }
        return praiseInfo;
    }


    /**
     * 更新一条论坛点赞表数据
     *
     * @param forumpraiseInfo 论坛点赞表模型
     **/
    @Override
    @Transactional
    public ForumPraiseInfo updateForumPraise(ForumPraiseInfo forumpraiseInfo) throws IOException {

        if (forumpraiseInfo.getPraiseId() >= 1)
            return forumPraiseRepository.save(forumpraiseInfo);

        return forumpraiseInfo;

    }


    /**
     * 删除一条论坛点赞表数据
     *
     * @param praiseId 论坛点赞表模型
     **/
    @Override
    @Transactional
    public void deleteForumPraiseByPraiseId(Integer praiseId) throws IOException {

        forumPraiseRepository.deleteById(praiseId);
    }

    /**
     * 批量删除一批论坛点赞表数据
     **/
    public void deleteForumPraiseByPraiseIdList(String praiseIdlist) throws IOException {


    }

    /**
     * 判断点赞
     *
     * @param forumId
     * @param uid
     * @return
     */
    @Override
    @Transactional
    public boolean isPraise(Integer forumId, Integer uid) throws IOException {
        return forumPraiseRepository.existsByForumIdAndUid(forumId, uid);
    }

    /**
     * 获得论坛点赞表一条记录
     *
     * @param praiseId praiseid
     * @return 返回一条ForumPraiseInfo
     **/
    @Override
    @Transactional
    public ForumPraiseInfo getForumPraiseByPraiseId(Integer praiseId) throws IOException {
        return forumPraiseRepository.findById(praiseId).get();
    }


    /**
     * 获得论坛点赞表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回ForumPraiseInfo
     **/
    @Override
    @Transactional
    public List<ForumPraiseInfo> getForumPraiseList(Specification<ForumPraiseInfo> condition, Sort sort) throws IOException {

        return forumPraiseRepository.findAll(condition, sort);

    }


    /**
     * 获得论坛点赞表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回ForumPraiseInfo
     **/
    @Override
    @Transactional
    public Page<ForumPraiseInfo> getForumPraiseList(Integer pageSize, Integer pageNumber, Specification<ForumPraiseInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1)
            pageNumber--;

        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);

        return forumPraiseRepository.findAll(condition, pageable);


    }


    //endregion
}



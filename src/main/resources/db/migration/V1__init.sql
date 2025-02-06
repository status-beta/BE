create schema if not exists status;

CREATE TABLE status.user (
                             user_id	varchar(50)		NOT NULL,
                             email	varchar(50)		NULL,
                             password	varchar(50)		NULL,
                             nickname	varchar(20)		NULL,
                             avartar_img	bytea		NULL,
                             provider	varchar(20)		NULL,
                             PRIMARY KEY (user_id)
);

COMMENT ON TABLE status.user IS '유저';
COMMENT ON COLUMN status.user.user_id IS '유저ID';
COMMENT ON COLUMN status.user.email IS '이메일';
COMMENT ON COLUMN status.user.password IS '비밀번호';
COMMENT ON COLUMN status.user.nickname IS '닉네임';
COMMENT ON COLUMN status.user.avartar_img IS '프로필이미지';
COMMENT ON COLUMN status.user.provider IS '소셜로그인공급자';


CREATE TABLE status.group (
                              group_id	varchar(50)		NOT NULL,
                              group_name	varchar(20)		NOT NULL,
                              group_img	bytea		NOT NULL,
                              PRIMARY KEY (group_id)
);

COMMENT ON TABLE status.group IS '그룹';
COMMENT ON COLUMN status.group.group_id IS '그룹ID';
COMMENT ON COLUMN status.group.group_name IS '그룹명';
COMMENT ON COLUMN status.group.group_img IS '그룹이미지';


CREATE TABLE status.group_user (
                                   group_user_id	varchar(50)		NOT NULL,
                                   group_id	varchar(50)		NOT NULL,
                                   user_id	varchar(50)		NOT NULL,
                                   reg_date	timestamp		NOT NULL,
                                   PRIMARY KEY (group_user_id)
);

COMMENT ON TABLE status.group_user IS '그룹유저';
COMMENT ON COLUMN status.group_user.group_user_id IS '그룹유저ID';
COMMENT ON COLUMN status.group_user.group_id IS '그룹ID';
COMMENT ON COLUMN status.group_user.user_id IS '유저ID';
COMMENT ON COLUMN status.group_user.reg_date IS '가입일';


CREATE TABLE status.schedule (
                                 schedule_id	int		NOT NULL,
                                 title	varchar(50)		NOT NULL,
                                 description	varchar(1000)		NOT NULL,
                                 start_date	timestamp		NOT NULL,
                                 end_date	timestamp		NOT NULL,
                                 create_date timestamp      NOT NULL,
                                 group_id	int		NOT NULL,
                                 author	int		NOT NULL,
                                 PRIMARY KEY (schedule_id)
);

COMMENT ON TABLE status.schedule IS '스케줄';
COMMENT ON COLUMN status.schedule.schedule_id IS '스케줄ID';
COMMENT ON COLUMN status.schedule.title IS '제목';
COMMENT ON COLUMN status.schedule.description IS '설명';
COMMENT ON COLUMN status.schedule.start_date IS '시작일';
COMMENT ON COLUMN status.schedule.end_date IS '마감일';
COMMENT ON COLUMN status.schedule.create_date IS '작성일';
COMMENT ON COLUMN status.schedule.group_id IS '그룹ID';
COMMENT ON COLUMN status.schedule.author IS '작성자';


CREATE TABLE status.post (
                             post_id	int		NOT NULL,
                             title	varchar(50)		NOT NULL,
                             content	varchar(1000)		NOT NULL,
                             create_date	timestamp		NOT NULL,
                             update_date	timestamp		NOT NULL,
                             view_count	bigint	DEFAULT 0	NOT NULL,
                             like_count	bigint	DEFAULT 0	NOT NULL,
                             image	bytea		NULL,
                             group_id	int		NOT NULL,
                             author int		NOT NULL,
                             PRIMARY KEY (post_id)
);

COMMENT ON TABLE status.post IS '게시글';
COMMENT ON COLUMN status.post.post_id IS '게시글ID';
COMMENT ON COLUMN status.post.title IS '제목';
COMMENT ON COLUMN status.post.content IS '내용';
COMMENT ON COLUMN status.post.create_date IS '작성일';
COMMENT ON COLUMN status.post.update_date IS '수정일';
COMMENT ON COLUMN status.post.view_count IS '조회수';
COMMENT ON COLUMN status.post.like_count IS '좋아요';
COMMENT ON COLUMN status.post.image IS '사진';
COMMENT ON COLUMN status.post.group_id IS '그룹ID';
COMMENT ON COLUMN status.post.author IS '작성자';


CREATE TABLE status.comment (
                                comment_id	int		NOT NULL,
                                parent_id	int		NULL,
                                content	varchar(300)		NOT NULL,
                                create_date	timestamp		NOT NULL,
                                update_date	timestamp		NOT NULL,
                                like_count	bigint		NOT NULL,
                                post_id	int		NOT NULL,
                                author	int		NOT NULL,
                                PRIMARY KEY (comment_id)
);

COMMENT ON TABLE status.comment IS '댓글';
COMMENT ON COLUMN status.comment.comment_id IS '댓글ID';
COMMENT ON COLUMN status.comment.parent_id IS '부모댓글ID';
COMMENT ON COLUMN status.comment.content IS '내용';
COMMENT ON COLUMN status.comment.create_date IS '작성일';
COMMENT ON COLUMN status.comment.update_date IS '수정일';
COMMENT ON COLUMN status.comment.like_count IS '좋아요';
COMMENT ON COLUMN status.comment.post_id IS '게시글ID';
COMMENT ON COLUMN status.comment.author IS '작성자';





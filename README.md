# Winter is Leaving And SPRING is Coming
> 겨울은 떠나고, 봄이 오고 있다.

- https://github.com/uyu423/winter-is-leaving-and-Spring-is-coming

## API (Endpoint)

### Timeline
- Path `/`

#### Get User Timeline
- GET `/`
- available Query Parameter `userId`
	```http
	GET /?userId=2 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:43:56 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":[{"id":2,"user":{"id":2,"email":"aaa@gmail.com","name":"aaa","createdAt":1514495174000,"updatedAt":null},"content":"Hello World!!!!!!","comments":[{"id":4,"postId":2,"user":{"id":3,"email":"bbb@gmail.com","name":"bbb","createdAt":1514495177000,"updatedAt":null},"content":null,"createdAt":1514647944000,"updatedAt":null},{"id":5,"postId":2,"user":{"id":3,"email":"bbb@gmail.com","name":"bbb","createdAt":1514495177000,"updatedAt":null},"content":null,"createdAt":1514647998000,"updatedAt":null},{"id":6,"postId":2,"user":{"id":3,"email":"bbb@gmail.com","name":"bbb","createdAt":1514495177000,"updatedAt":null},"content":"Hello??","createdAt":1514648259000,"updatedAt":null},{"id":7,"postId":2,"user":{"id":2,"email":"aaa@gmail.com","name":"aaa","createdAt":1514495174000,"updatedAt":null},"content":"안뇽하세용???","createdAt":1514648266000,"updatedAt":null}],"createdAt":1514495191000,"updatedAt":null},{"id":1,"user":{"id":2,"email":"aaa@gmail.com","name":"aaa","createdAt":1514495174000,"updatedAt":null},"content":"Hello World!!!!!!","comments":[{"id":2,"postId":1,"user":{"id":3,"email":"bbb@gmail.com","name":"bbb","createdAt":1514495177000,"updatedAt":null},"content":null,"createdAt":1514647276000,"updatedAt":null},{"id":3,"postId":1,"user":{"id":3,"email":"bbb@gmail.com","name":"bbb","createdAt":1514495177000,"updatedAt":null},"content":null,"createdAt":1514647939000,"updatedAt":null}],"createdAt":1514495189000,"updatedAt":null}],"success":true}
	```

### User
- `/user`

#### Get User Info
- GET `/{userId}`
	```http
	GET /user/1 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:44:55 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":1,"email":"ccc@gmail.com","name":"cccccc","createdAt":1514495166000,"updatedAt":null},"success":true}
	```

#### Create New User
- POST `/`
	```http
	POST /user HTTP/1.1
	Content-Length: 53
	Host: localhost:8080
	Content-Type: application/json

	{
	  "email": "uyu423@gmail.com",
	  "name": "Yu Yowu"
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:46:24 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":5,"email":"uyu423@gmail.com","name":"Yu Yowu","createdAt":1514648784069,"updatedAt":null},"success":true}
	```

#### Update User Info
- PUT `/{userId}`
	```http
	PUT /user/5 HTTP/1.1
	Content-Length: 26
	Host: localhost:8080
	Content-Type: application/json

	{
	  "name": "Yu Yongwoo"
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:47:12 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":5,"email":"uyu423@gmail.com","name":"Yu Yongwoo","createdAt":1514648783000,"updatedAt":1514648832864},"success":true}
	```

#### Delete User
- DELETE `/{userId}`
	```http
	DELETE /user/5 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:47:42 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":null,"success":true}
	```

#### Get Following Users
- GET `/{userId}/follow`
	```http
	GET /user/4/follow HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:50:18 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":[{"id":4,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"followUser":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"createdAt":1514495180000},{"id":9,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"followUser":{"id":1,"email":"ccc@gmail.com","name":"cccccc","createdAt":1514495166000,"updatedAt":null},"createdAt":1514648957000}],"success":true}
	```

#### Following User
- POST `/{userId}/follow`
	```http
	POST /user/4/follow HTTP/1.1
	Content-Length: 23
	Host: localhost:8080
	Content-Type: application/json

	{
	  "followUserId": 1
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:49:18 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":9,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"followUser":{"id":1,"email":"ccc@gmail.com","name":"cccccc","createdAt":1514495166000,"updatedAt":null},"createdAt":1514648958260},"success":true}
	```

#### Get User Posts
- GET `/{userId}/post`
	```http
	GET /user/4/post HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:54:32 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":[{"id":6,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"My Best Webtoon is 'Catoon Hero'","comments":[],"createdAt":1514649205000,"updatedAt":null},{"id":4,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"Hello World!!!!!!","comments":[],"createdAt":1514495196000,"updatedAt":null},{"id":5,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"Hello World!!!!!!","comments":[],"createdAt":1514495196000,"updatedAt":null}],"success":true}
	```

#### Unfollow User
- POST `/{userId}/unfollow`
	```http
	POST /user/4/unfollow HTTP/1.1
	Content-Length: 23
	Host: localhost:8080
	Content-Type: application/json

	{
	  "followUserId": 1
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:51:15 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":null,"success":true}
	```

### Post
- `/post`

#### Create New Post
- POST `/`
	```http
	POST /post HTTP/1.1
	Content-Length: 66
	Host: localhost:8080
	Content-Type: application/json

	{
	  "userId": 4,
	  "content": "My Best Webtoon is 'Catoon Hero'"
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:53:26 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":6,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"My Best Webtoon is 'Catoon Hero'","comments":null,"createdAt":1514649206659,"updatedAt":null},"success":true}
	```

#### Get Post One
- GET `/{postId}`
	```http
	GET /post/6 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:56:24 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":6,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"My Best Webtoon is 'Catoon Hero'","comments":[],"createdAt":1514649205000,"updatedAt":null},"success":true}
	```

#### Modify Post
- PUT `/{postId}`
	```http
	PUT /post/6 HTTP/1.1
	Content-Length: 49
	Host: localhost:8080
	Content-Type: application/json

	{
	  "content": "My Best Webtoon is 'Reva Toon'"
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:57:11 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":6,"user":{"id":4,"email":"eee@gmail.com","name":"eee","createdAt":1514495180000,"updatedAt":null},"content":"My Best Webtoon is 'Reva Toon'","comments":[],"createdAt":1514649205000,"updatedAt":1514649431694},"success":true}
	```

#### Delete Post
- DELETE `/{postId}`
	```http
	DELETE /post/6 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 15:57:56 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":null,"success":true}
	```

#### Create Post Comment
- POST `/{postId}/comment`
	```http
	POST /post/5/comment HTTP/1.1
	Content-Length: 60
	Host: localhost:8080
	Content-Type: application/json

	{
	  "userId": 1,
	  "content": "Do You Know Yowu?"
	}

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 16:31:09 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":{"id":8,"postId":5,"user":{"id":1,"email":"ccc@gmail.com","name":"cccccc","createdAt":1514495166000,"updatedAt":null},"content":"Do You Know Yowu?","createdAt":1514651469704,"updatedAt":null},"success":true}
	```

#### Delete Post Comment
- DELETE `/{postId}/comment/{commentId}`
	```
	DELETE /post/5/comment/8 HTTP/1.1
	Host: localhost:8080

	HTTP/1.1 200
	date: Sat, 30 Dec 2017 16:32:33 GMT
	transfer-encoding: chunked
	content-type: application/json;charset=UTF-8

	{"data":null,"success":true}
	```

## Domain (Entity)

![image](https://user-images.githubusercontent.com/8033320/34422819-37d60fde-ec5b-11e7-9575-2cd62423676c.png)

### User
- id
- email
- name
- createdAt
- updatedAt

### Post
- id
- userId
- content
- createdAt
- updatedAt

### Comment
- id
- postId
- userId
- content
- createdAt

### FollowRelation
- id
- userId
- followUserId
- createdAt

### DDL
```sql
-- 사용자
CREATE TABLE `user` (
	`id`        BIGINT       NOT NULL COMMENT 'id', -- id
	`email`     VARCHAR(100) NOT NULL COMMENT '이메일', -- 이메일
	`name`      VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`createdAt` TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시', -- 생성일시
	`updatedAt` TIMESTAMP    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트일시' -- 업데이트일시
)
COMMENT '사용자';

-- 사용자
ALTER TABLE `user`
	ADD CONSTRAINT `PK_user` -- 사용자 기본키
		PRIMARY KEY (
			`id` -- id
		);

-- 사용자 유니크 인덱스
CREATE UNIQUE INDEX `UIX_user`
	ON `user` ( -- 사용자
		`email` ASC -- 이메일
	);

ALTER TABLE `user`
	MODIFY COLUMN `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id';

-- 포스트
CREATE TABLE `post` (
	`id`        BIGINT    NOT NULL COMMENT 'id', -- id
	`userId`    BIGINT    NOT NULL COMMENT '사용자id', -- 사용자id
	`content`   TEXT      NOT NULL COMMENT '내용', -- 내용
	`createdAt` TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시', -- 생성일시
	`updatedAt` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트일시' -- 업데이트일시
)
COMMENT '포스트';

-- 포스트
ALTER TABLE `post`
	ADD CONSTRAINT `PK_post` -- 포스트 기본키
		PRIMARY KEY (
			`id` -- id
		);

ALTER TABLE `post`
	MODIFY COLUMN `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id';

-- 팔로우
CREATE TABLE `followRelation` (
	`id`           BIGINT    NOT NULL COMMENT 'id', -- id
	`userId`       BIGINT    NOT NULL COMMENT '사용자Id', -- 사용자Id
	`followUserId` BIGINT    NOT NULL COMMENT '팔로우사용자Id', -- 팔로우사용자Id
	`createdAt`    TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시' -- 생성일시
)
COMMENT '팔로우';

-- 팔로우
ALTER TABLE `followRelation`
	ADD CONSTRAINT `PK_followRelation` -- 팔로우 기본키
		PRIMARY KEY (
			`id` -- id
		);

ALTER TABLE `followRelation`
	MODIFY COLUMN `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id';

-- 댓글
CREATE TABLE `comment` (
	`id`        BIGINT    NOT NULL COMMENT 'id', -- id
	`postId`    BIGINT    NOT NULL COMMENT '포스트id', -- 포스트id
	`userId`    BIGINT    NOT NULL COMMENT '사용자id', -- 사용자id
	`content`   TEXT      NULL     COMMENT '내용', -- 내용
	`createdAt` TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시', -- 생성일시
	`updatedAt` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '업데이트일시' -- 업데이트일시
)
COMMENT '댓글';

-- 댓글
ALTER TABLE `comment`
	ADD CONSTRAINT `PK_comment` -- 댓글 기본키
		PRIMARY KEY (
			`id` -- id
		);

ALTER TABLE `comment`
	MODIFY COLUMN `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id';

-- 포스트
ALTER TABLE `post`
	ADD CONSTRAINT `FK_user_TO_post` -- 사용자 -> 포스트
		FOREIGN KEY (
			`userId` -- 사용자id
		)
		REFERENCES `user` ( -- 사용자
			`id` -- id
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX `FK_user_TO_post` (
		`userId` ASC -- 사용자id
	);

-- 팔로우
ALTER TABLE `followRelation`
	ADD CONSTRAINT `FK_user_TO_followRelation` -- 사용자 -> 팔로우
		FOREIGN KEY (
			`userId` -- 사용자Id
		)
		REFERENCES `user` ( -- 사용자
			`id` -- id
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX `FK_user_TO_followRelation` (
		`userId` ASC -- 사용자Id
	);

-- 댓글
ALTER TABLE `comment`
	ADD CONSTRAINT `FK_post_TO_comment` -- 포스트 -> 댓글
		FOREIGN KEY (
			`postId` -- 포스트id
		)
		REFERENCES `post` ( -- 포스트
			`id` -- id
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	ADD INDEX `FK_post_TO_comment` (
		`postId` ASC -- 포스트id
	);

-- 팔로우
ALTER TABLE `followRelation`
	ADD CONSTRAINT `FK_user_TO_followRelation2` -- 사용자 -> 팔로우2
		FOREIGN KEY (
			`followUserId` -- 팔로우사용자Id
		)
		REFERENCES `user` ( -- 사용자
			`id` -- id
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE;

-- 댓글
ALTER TABLE `comment`
	ADD CONSTRAINT `FK_user_TO_comment` -- 사용자 -> 댓글
		FOREIGN KEY (
			`userId` -- 사용자id
		)
		REFERENCES `user` ( -- 사용자
			`id` -- id
		)
		ON DELETE CASCADE
		ON UPDATE CASCADE;
```

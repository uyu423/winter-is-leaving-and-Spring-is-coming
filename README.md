# Winter is Leaving And SPRING is Coming
> 겨울은 떠나고, 봄이 오고 있다.

## Domain (DDL)

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

## API

### Timeline
- `/`

#### Get Timeline
- GET `/`

### User
- `/user`

#### Get User Info
- GET `/{userId}`

#### Create New User
- POST `/`

#### Update User Info
- PUT `/{userId}`

#### Delete User
- DELETE `/{userId}`

#### Get User Followers
- GET `/{userId}/follower`

#### Following User
- POST `/{userId}/follow`

#### Unfollow User
- DELETE `/{userId}/follow`

### Post
- `/post`

#### Create New Post
- POST `/`

#### Get Posts
- GET `/`
- available Query Parameter `userId`

#### Get Post One
- GET `/{postId}`

#### Modify Post
- PUT `/{postId}`

#### Delete Post
- DELETE `/{postId}`

#### Create Post Comment
- POST `/{postId}/comment`

#### Delete Post Comment
- DELETE `/{postId}/comment/{commentId}`

#### Modify Post Comment
- PUT `/{postId}/comment/{commentId}`

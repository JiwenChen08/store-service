create table t_store
(
    id               bigserial
        primary key,
    store_no         varchar(64) not null,
    name             text,
    address          text,
    post_code        varchar(20),
    city_id          bigint,
    city_name        varchar(100),
    phone            varchar(50),
    email            varchar(100),
    longitude        varchar(50),
    latitude         varchar(50),
    status           integer,
    operating_status integer,
    create_at        timestamp with time zone default CURRENT_TIMESTAMP,
    update_at        timestamp with time zone default CURRENT_TIMESTAMP
);

comment on table t_store is '门店表';

comment on column t_store.id is '主键 ID';

comment on column t_store.store_no is '门店编号';

comment on column t_store.name is '门店名称';

comment on column t_store.address is '门店详细地址';

comment on column t_store.post_code is '邮政编码';

comment on column t_store.city_id is '城市 ID';

comment on column t_store.city_name is '城市名称';

comment on column t_store.phone is '联系电话';

comment on column t_store.email is '邮箱';

comment on column t_store.longitude is '经度';

comment on column t_store.latitude is '纬度';

comment on column t_store.status is '状态';

comment on column t_store.operating_status is '营业状态';

comment on column t_store.create_at is '创建时间';

comment on column t_store.update_at is '更新时间';


create table t_store_biz_hour
(
    id         bigserial
        primary key,
    store_id   bigint  not null,
    day_type   integer not null,
    day_name   varchar(20),
    open_time  time,
    close_time time
);

comment on table t_store_biz_hour is '门店营业时间表';

comment on column t_store_biz_hour.id is '主键';

comment on column t_store_biz_hour.store_id is '门店ID (关联 t_store.id)';

comment on column t_store_biz_hour.day_type is '星期类型（1=周一,... 7=周日）';

comment on column t_store_biz_hour.day_name is '星期名称';

comment on column t_store_biz_hour.open_time is '营业开始时间';

comment on column t_store_biz_hour.close_time is '营业结束时间';


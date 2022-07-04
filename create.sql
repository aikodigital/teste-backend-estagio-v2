
create table equipment (id uuid not null, name varchar(100) not null, equipment_model_id uuid, primary key (id));
create table equipment_model (id uuid not null, name varchar(100) not null, primary key (id));
create table equipment_model_state_hourly_earnings (id uuid not null, value float4 not null, equipment_model_id uuid, equipment_state_id uuid, primary key (id));
create table equipment_position_history (id uuid not null, date TIMESTAMP WITHOUT TIME ZONE not null, lat float4 not null, lon float4 not null, equipment_id uuid, primary key (id));
create table equipment_state (id uuid not null, color varchar(100) not null, name varchar(100) not null, primary key (id));
create table equipment_state_history (id uuid not null, date TIMESTAMP WITHOUT TIME ZONE not null, equipment_id uuid, equipment_state_id uuid, primary key (id));
alter table equipment add constraint FKcuj2jw9cv3p5f9icrqyorc7eb foreign key (equipment_model_id) references equipment_model;
alter table equipment_model_state_hourly_earnings add constraint FK4qgsqttbi93giw1dv7wpek7rq foreign key (equipment_model_id) references equipment_model;
alter table equipment_model_state_hourly_earnings add constraint FKlvnisfbgnceki5vdcx4007lvf foreign key (equipment_state_id) references equipment_state;
alter table equipment_position_history add constraint FKa49fh2hu80oj5imjrmqfep9yl foreign key (equipment_id) references equipment;
alter table equipment_state_history add constraint FKbjoisje51kuxlm2j8n47qexas foreign key (equipment_id) references equipment;
alter table equipment_state_history add constraint FKw93ox1tgtivyxx9qfwdhx0bd foreign key (equipment_state_id) references equipment_state;

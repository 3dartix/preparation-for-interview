-- инсерты
INSERT INTO cinema_bd.ticket_table (`number`,`unique_user_id`,`seance_id`) VALUES (4,'23425рf34f4f3',3);
INSERT INTO cinema_bd.seance_table (
`date`,
`cost`,
`number_seats`,
`film_id`,
`time_start`)
VALUES, ('2021-01-01', 20, 100,1, '10:30:00');
INSERT INTO cinema_bd.film_table (`name`, `timing`) VALUES ('Фильм 1', 120);

-- статистика по выручке и количеству проданных билетов на каждый фильм
select f.name as 'название фильма', sum(s.cost) as 'выручка', count(t.unique_user_id) as 'количество проданных билетов' from ticket_table as t
         join seance_table as s on t.seance_id = s.id
         join film_table as f on f.id = s.film_id
	group by s.film_id;
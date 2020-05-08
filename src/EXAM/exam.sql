-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 08 2020 г., 14:39
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `exam`
--

-- --------------------------------------------------------

--
-- Структура таблицы `math`
--

CREATE TABLE `math` (
  `id` int(11) NOT NULL,
  `question` varchar(256) NOT NULL,
  `answ1` varchar(128) NOT NULL,
  `answ2` varchar(128) NOT NULL,
  `answ3` varchar(128) NOT NULL,
  `answ4` varchar(128) NOT NULL,
  `subjectid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `math`
--

INSERT INTO `math` (`id`, `question`, `answ1`, `answ2`, `answ3`, `answ4`, `subjectid`) VALUES
(1, 'From the proposed equations, select incomplete quadratic equations', 'х2 + х + 1 = 0', '16х2 = 4', 'х2 – 3х = 0', '5х2 - х - 2 = 0', 0),
(2, 'What is an equation?', 'it is an identity whose one member is unknown', 'it is an equality in which one member is known', 'it is an identity in which is unknown only \"y\"', 'this identity, which is solved by the Vieta theorem', 0),
(3, 'How many roots does the quadratic equation have?', '1', '2', '3', '4', 0),
(4, 'If the discriminant is negative, then', 'There are no roots of the equation', 'There are two roots of the equation\r\n  ', 'The root is zero\r\n ', 'There are two roots, but they are not among the real numbers.', 0),
(5, 'How to determine the number of roots in a power equation?', 'By the number of unknowns', 'By value of discriminant', 'The highest degree of equation', 'By the first number in the equation', 0),
(6, 'Incomplete equations include equations in which', '\"a\" and \"c\" are zero', '\"a\" and \"b\" are equal to zero', 'no \"b\"', '\"b\" and/or \"c\" are equal to zero', 0),
(7, 'What is the difference between a quadratic equation and a linear one?', 'The senior term of the quadratic equation has degree 2, and linear 1', 'Number of members', 'End result of identity', 'There are no correct answers.', 0),
(8, 'In the equation, the coefficient \"c\" is this?', 'Free member', 'The main coefficient of the equation', 'The second coefficient of the equation', 'The first term of the equation', 0),
(9, 'If “c” and “c” are equal to zero, can the equation be called quadratic?', 'Yes you can', 'This is a linear equation', 'This is a fractional equation', 'This is an irrational equation', 0),
(10, 'In which case can the Vieta theorem be used?', 'When x2 is a multiple of 3', 'When x2 is a natural number', 'When x2 is a multiple of 1', 'When x2 is a multiple of 2', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `surname` varchar(128) NOT NULL,
  `role` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `name`, `surname`, `role`) VALUES
(1, 'fasdad', 'asfasfasf', 'Adasd', 'asfasf', 'USER'),
(2, 'ablizov123', '13asd', 'Nail', 'Ablizov', 'USER'),
(3, 'metallov02', '789asd', 'Almas', 'Metallov', 'USER'),
(4, 'akhmedova123', '123asd', 'Diana', 'Akhmedova', 'USER'),
(5, 'rara', 'rara', 'Alibek', 'Saginbaev', 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `math`
--
ALTER TABLE `math`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `math`
--
ALTER TABLE `math`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

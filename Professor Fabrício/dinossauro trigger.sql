CREATE TABLE grupo
(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE eras
(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE,
	ano_inicio INT NOT NULL,
	ano_fim INT NOT NULL
);

CREATE TABLE descobridor
(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE paises
(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE dinossauro
(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL UNIQUE,
	tonelada DECIMAL(5,2) NOT NULL,
	ano_descoberta INT,
	descobridor_id INT NOT NULL,
	era_id INT NOT NULL,
	pais_id INT NOT NULL,
	grupo_id INT NOT NULL,
	FOREIGN KEY(descobridor_id) REFERENCES descobridor(id),
	FOREIGN KEY(era_id) REFERENCES eras(id),
	FOREIGN KEY(pais_id) REFERENCES paises(id),
	FOREIGN KEY(grupo_id) REFERENCES grupo(id)
);
---------------------------------------------------------------

-- Função para validar a era
DELIMITER //
CREATE FUNCTION valida_era()
RETURNS TRIGGER AS $$
BEGIN
    -- Verifica se o ano de descoberta está dentro do intervalo da era
    IF NEW.ano_descoberta IS NOT NULL THEN
        DECLARE era_inicio INT;
        DECLARE era_fim INT;

        SELECT ano_inicio, ano_fim INTO era_inicio, era_fim FROM eras WHERE id = NEW.era_id;

        IF NEW.ano_descoberta < era_inicio OR NEW.ano_descoberta > era_fim THEN
            RAISE EXCEPTION 'Ano de descoberta % não está dentro do período da era % (% - %)', NEW.ano_descoberta, era_ini, era_fim;
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
DELIMITER ;

-- Trigger para chamar a função de validação antes de inserir um dinossauro
CREATE TRIGGER tg_valida_era
BEFORE INSERT OR UPDATE ON dinossauro
FOR EACH ROW
EXECUTE FUNCTION valida_era();

















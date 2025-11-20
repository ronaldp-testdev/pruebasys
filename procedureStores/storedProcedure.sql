CREATE OR REPLACE PROCEDURE proc_create_session(p_user_id sessions.usuarios_id_usuario%type)
as $$
declare
    v_fecha_ingreso sessions.fecha_ingreso%type;
begin
    v_fecha_ingreso:= CURRENT_TIMESTAMP;
    INSERT INTO sessions (activated, fecha_ingreso, usuarios_id_usuario)
        VALUES (true, v_fecha_ingreso, p_user_id);
EXCEPTION
    when others then
        RAISE notice 'Error';
end;
$$ LANGUAGE plpgsql;
---


CREATE OR REPLACE PROCEDURE proc_cerrar_session(p_id sessions.id%type)
as $$
declare
    v_fecha_cierre sessions.fecha_cierre%type;
begin
    v_fecha_cierre:= CURRENT_TIMESTAMP;
    UPDATE sessions set fecha_cierre = v_fecha_cierre
        WHERE sessions.id = p_id;
EXCEPTION
    when others then
        RAISE notice 'Error';
end;
$$ LANGUAGE plpgsql;
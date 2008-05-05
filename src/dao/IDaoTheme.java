package dao;

import java.util.List;

import entities.Theme;

public interface IDaoTheme {
	Theme getOne(int id);
	void addOne(Theme theme);
	void updateOne(Theme theme);
	void deleteOne(Theme theme);
	List<Theme> listAll();
}

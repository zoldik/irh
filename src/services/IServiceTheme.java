package services;

import java.util.List;

import entities.Theme;

public interface IServiceTheme {
	Theme getTheme(int id);
	void addTheme(Theme theme);
	void updateTheme(Theme theme);
	void deleteTheme(Theme theme);
	List<Theme> listThemes();
}

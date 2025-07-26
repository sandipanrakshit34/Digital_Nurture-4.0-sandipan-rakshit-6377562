import axios from 'axios';
import GitClient from './GitClient';

// Mock axios module
jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    // Mocked repository data
    const mockData = [
      { name: 'Repo1' },
      { name: 'Repo2' },
      { name: 'Repo3' }
    ];

    // Mock axios.get to resolve with mockData
    axios.get.mockResolvedValue({ data: mockData });

    // Call the API function
    const response = await GitClient.getRepositories('techiesyed');

    // Check results
    expect(response.data).toEqual(mockData);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });

  test('should handle API error', async () => {
    // Mock an error
    axios.get.mockRejectedValue(new Error('Network error'));

    await expect(GitClient.getRepositories('techiesyed')).rejects.toThrow('Network error');
  });
});
